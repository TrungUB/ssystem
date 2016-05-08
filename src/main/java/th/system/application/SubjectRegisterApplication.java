package th.system.application;

import th.system.domain.ScoreEntry;
import th.system.domain.Student;
import th.system.domain.constant.RegisterType;
import th.system.repository.StudentRepository;
import th.system.repository.SubjectRegisterRepository;
import th.system.repository.SubjectRepository;

public class SubjectRegisterApplication {
    
    private SubjectRepository subjectRepository;
    private StudentRepository studentRepository;
    private SubjectRegisterRepository registerRepository;
    
    public SubjectRegisterApplication() {
        subjectRepository = new SubjectRepository();
        studentRepository = new StudentRepository();
        registerRepository = new SubjectRegisterRepository();
    }
    
    public boolean hasNoSubject() {
        return subjectRepository.hasNoSubject();
    }
    
    public boolean isVeryFirstTimeRegister(String id) {
        return !registerRepository.doesStudentRegister(id);
    }
    
    public boolean doesStudentExist(String id) {
        return studentRepository.doesStudentExist(id);
    }
    
    public void chooseCourse(String studentId, RegisterType type) {
        registerRepository.registerCourseForStudent(studentRepository.getStudent(studentId), type);
    }
    
    public void register(String studentId, String subjectId) {
        registerRepository.registerSubjectForStudent(studentId, new ScoreEntry(subjectRepository.getSubjectById(subjectId), null, null));
    }
    
    public void fetchSubjectData() {
        subjectRepository.fetchSubjectData();
    }
    
    public void getRegisterSubjects(String studentId) {
        registerRepository
            .getAllNotScoredSubject(studentId)
            .getAll()
            .stream()
            .map(e -> String.format("[%s] %s", e.getSubjectId(), e.getSubject().getSubjectName()))
            .forEach(System.out::println);
    }
    
    public void getAllScoreResult(String studentId) {
        registerRepository
            .getAllScoredSubject(studentId)
            .getAll()
            .stream()
            .map(
                e -> String.format(
                    "[%s] %s: %f - %f",
                    e.getSubjectId(),
                    e.getSubject().getSubjectName(),
                    e.getMidtermScore().get(),
                    e.getFinalScore().get()))
            .forEach(System.out::println);
    }
    
    public boolean doesSubjectExist(String studentId, String subjectId) {
        if (!doesStudentExist(studentId)) return false;
        
        return registerRepository.getAllNotScoredSubject(studentId).containsSubject(subjectId);
    }
    
    public void updateScore(String studentId, String subjectId, float midtermScore, float finalScore) {
        registerRepository.updateScore(studentId, subjectId, midtermScore, finalScore);
    }
    
    public void displayAllStudentList() {
        studentRepository.getStudentList().getAll().stream().map(Student::getId).forEach(System.out::println);
    }
    
    public boolean isConsideredGraduate(String studentId) {
        if (!doesStudentExist(studentId)) {
            System.out.println(String.format("Student %s does not exist!", studentId));
            return false;
        }
        
        if(isVeryFirstTimeRegister(studentId)) {
            System.out.println(String.format("Student %s have no registered subject!", studentId));
            return true;
        }
        
        return registerRepository.getAllScoredSubject(studentId).getAll().stream().filter(e -> !e.isPass()).count() == 0
            && registerRepository.getAllNotScoredSubject(studentId).getAll().stream().count() == 0;
    }
    
}

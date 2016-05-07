package th.system.application;

import th.system.domain.ScoreEntry;
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
    
}

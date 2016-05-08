package th.system.repository;

import th.system.domain.ScoreEntry;
import th.system.domain.Student;
import th.system.domain.constant.RegisterType;
import th.system.domain.fcc.ScoreEntries;
import th.system.domain.fcc.SubjectRegisterEntities;

public class SubjectRegisterRepository {
    
    private static SubjectRegisterEntities subjectRegisters;
    
    public SubjectRegisterRepository() {
        if (subjectRegisters == null) {
            subjectRegisters = new SubjectRegisterEntities();
        }
    }
    
    public boolean doesStudentRegister(String id) {
        return subjectRegisters.doesStudentRegister(id);
    }
    
    public void registerCourseForStudent(Student student, RegisterType type) {
        subjectRegisters.registerStudent(student, type);
    }
    
    public void registerSubjectForStudent(String studentId, ScoreEntry entry) {
        subjectRegisters.registerSubject(studentId, entry);
    }
    
    public ScoreEntries getAllScoredSubject(String studentId) {
        return subjectRegisters.getAllScoredSubject(studentId);
    }
    
    public ScoreEntries getAllNotScoredSubject(String studentId) {
        return subjectRegisters.getAllNotScoredSubject(studentId);
    }

    public void updateScore(String studentId, String subjectId, float midtermScore, float finalScore) {
        subjectRegisters.updateScore(studentId, subjectId, midtermScore, finalScore);
    }
}

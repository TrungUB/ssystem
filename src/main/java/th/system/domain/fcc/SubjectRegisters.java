package th.system.domain.fcc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import th.system.domain.ScoreEntry;
import th.system.domain.Student;
import th.system.domain.constant.RegisterType;
import th.system.domain.register.FreeSubjectRegister;
import th.system.domain.register.ScheduledSubjectRegister;
import th.system.domain.register.SubjectRegister;

public class SubjectRegisters {
    
    private Map<String, SubjectRegister> registerMap;
    
    public SubjectRegisters() {
        registerMap = new HashMap<>();
    }
    
    public boolean doesStudentExist(String key) {
        return registerMap.containsKey(key);
    }
    
    public void registerStudent(Student student, RegisterType registerType) {
        registerMap.put(student.getId(), createSubjectRegister(student, registerType));
    }
    
    private SubjectRegister createSubjectRegister(Student student, RegisterType registerType) {
        return registerType == RegisterType.SCHEDULED ? new ScheduledSubjectRegister(student) : new FreeSubjectRegister(student);
    }
    
    public List<SubjectRegister> getAll() {
        return new ArrayList<>(registerMap.values());
    }
    
    public void registerSubject(String studentId, ScoreEntry entry) {
        registerMap.get(studentId).registerSubject(entry);
    }
    
    public void updateScore(String studentId, ScoreEntry entry) {
        registerMap.get(studentId).getScoreEntries().addEntry(entry);
    }
}

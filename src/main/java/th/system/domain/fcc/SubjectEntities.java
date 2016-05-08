package th.system.domain.fcc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import th.system.domain.subject.UniversitySubject;

public class SubjectEntities {
    
    private Map<String, UniversitySubject> subjectMap;
    
    public SubjectEntities(List<? extends UniversitySubject> subjects) {
        subjectMap = new HashMap<>();
        subjects.forEach(subject -> addSubject(subject));
    }
    
    public SubjectEntities addSubject(UniversitySubject subject) {
        subjectMap.put(subject.getSubjectId(), subject);
        return this;
    }
    
    public UniversitySubject findSubjectById(String id) {
        return subjectMap.get(id);
    }
    
    public List<UniversitySubject> getAll() {
        return new ArrayList<>(subjectMap.values());
    }

    public boolean doesExist(String id) {
        return subjectMap.containsKey(id);
    }

    public boolean isEmpty() {
        return subjectMap.isEmpty();
    }
}

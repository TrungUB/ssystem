package th.system.domain.fcc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import th.system.domain.subject.UniversitySubject;

public class SubjectEntities implements Entities<UniversitySubject> {
    
    private Map<String, UniversitySubject> subjectMap;
    
    public SubjectEntities(List<? extends UniversitySubject> subjects) {
        subjectMap = new HashMap<>();
        subjects.forEach(subject -> add(subject));
    }
    
    @Override
    public SubjectEntities add(UniversitySubject subject) {
        subjectMap.put(subject.getSubjectId(), subject);
        return this;
    }
    
    @Override
    public UniversitySubject findById(String id) {
        return subjectMap.get(id);
    }
    
    @Override
    public List<UniversitySubject> getAll() {
        return new ArrayList<>(subjectMap.values());
    }
    
    @Override
    public boolean contains(String id) {
        return subjectMap.containsKey(id);
    }
    
    @Override
    public boolean isEmpty() {
        return subjectMap.isEmpty();
    }
    
    @Override
    public Entities<UniversitySubject> delete(String id) {
        subjectMap.remove(id);
        return this;
    }
}

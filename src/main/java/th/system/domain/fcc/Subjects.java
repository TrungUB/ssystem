package th.system.domain.fcc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import th.system.domain.UniversitySubject;

public class Subjects {
    private Map<String, UniversitySubject> subjectMap;
    
    public Subjects(List<UniversitySubject> subjects) {
        subjectMap = new HashMap<>();
        subjects.forEach(subject -> subjectMap.put(subject.getSubjectId(), subject));
    }
    
    public List<UniversitySubject> getAll() {
        return new ArrayList<>(subjectMap.values());
    }

    public boolean doesExist(String id) {
        return subjectMap.containsKey(id);
    }
}

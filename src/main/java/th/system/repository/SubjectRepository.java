package th.system.repository;

import java.util.List;
import java.util.stream.Collectors;

import th.system.domain.fcc.SubjectEntities;
import th.system.domain.subject.FreeRegisterSubject;
import th.system.domain.subject.ScheduledSubject;
import th.system.domain.subject.UniversitySubject;
import th.system.infrastructure.SubjectInfrastructure;

public class SubjectRepository {
    
    private SubjectInfrastructure subjectInfra;
    private static SubjectEntities subjects;
    
    public SubjectRepository() {
        subjectInfra = new SubjectInfrastructure();
    }
    
    public boolean hasNoSubject() {
        return subjects == null || subjects.isEmpty();
    }
    
    public void fetchSubjectData() {
        if (hasNoSubject()) {
            subjects = subjectInfra.fetchSubjectData();
        }
    }
    
    public UniversitySubject getSubjectById(String id) {
        return subjects.findById(id);
    }
    
    public List<UniversitySubject> getAllFreeCourseSubject() {
        return subjects.getAll().stream().filter(e -> e instanceof FreeRegisterSubject).collect(Collectors.toList());
    }

    public List<UniversitySubject> getAllScheduleCourseSubject() {
        return subjects.getAll().stream().filter(e -> e instanceof ScheduledSubject).collect(Collectors.toList());
    }
}

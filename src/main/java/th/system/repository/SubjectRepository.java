package th.system.repository;

import th.system.domain.fcc.SubjectEntities;
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
        return subjects.findSubjectById(id);
    }
}

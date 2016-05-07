package th.system.domain.subject;

import th.system.domain.fcc.SubjectEntities;

public class FreeRegisterSubject extends UniversitySubject {

    private SubjectEntities predetermineSubjects;
    
    public FreeRegisterSubject(String subjectId, String subjectName, int credit, SubjectEntities predetermineSubjects) {
        super(subjectId, subjectName, credit);
        this.predetermineSubjects = predetermineSubjects;
    }
    
    public boolean needAnySubjectBefore(String id) {
        return predetermineSubjects.doesExist(id);
    }
    
    public static FreeRegisterSubject valueOf(UniversitySubject subject, SubjectEntities predetermineSubjects) {
        return new FreeRegisterSubject(subject.getSubjectId(), subject.getSubjectName(), subject.getCredit(), predetermineSubjects);
    }

}

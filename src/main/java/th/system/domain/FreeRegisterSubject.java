package th.system.domain;

import th.system.domain.fcc.Subjects;

public class FreeRegisterSubject extends UniversitySubject {

    private Subjects predetermineSubjects;
    
    public FreeRegisterSubject(String subjectId, String subjectName, int credit, Subjects predetermineSubjects) {
        super(subjectId, subjectName, credit);
        this.predetermineSubjects = predetermineSubjects;
    }
    
    public boolean needAnySubjectBefore(String id) {
        return predetermineSubjects.doesExist(id);
    }

}

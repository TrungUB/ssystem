package th.system.domain;

public class ScheduledSubject extends UniversitySubject {
    
    private String semester;
    
    public ScheduledSubject(String subjectId, String subjectName, int credit, String semester) {
        super(subjectId, subjectName, credit);
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

}

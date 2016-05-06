package th.system.domain;

public class UniversitySubject {
    private String subjectId;
    private String subjectName;
    private int credit;
    
    public UniversitySubject(String subjectId, String subjectName, int credit) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.credit = credit;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getCredit() {
        return credit;
    }

}

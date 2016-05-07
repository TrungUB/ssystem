package th.system.domain.register;

import th.system.domain.ScoreEntry;
import th.system.domain.Student;
import th.system.domain.fcc.ScoreEntries;

public abstract class SubjectRegister {
    
    private Student student;
    private ScoreEntries scoreEntries;
    
    public SubjectRegister(Student student) {
        this.student = student;
        this.scoreEntries = new ScoreEntries(null);
    }
    
    public String getStudentId() {
        return student.getId();
    }
    
    public void registerSubject(ScoreEntry entry) {
        if(!isStatisfied(entry)) {
            System.out.println("You can not register this subject.");
            return;
        }
        scoreEntries.addEntry(entry);
    }
    
    protected abstract boolean isStatisfied(ScoreEntry entry);

    public ScoreEntries getScoreEntries() {
        return new ScoreEntries(scoreEntries.getAll());
    }
}

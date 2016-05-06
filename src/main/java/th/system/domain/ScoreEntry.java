package th.system.domain;

import java.util.Optional;

public class ScoreEntry {
    private UniversitySubject subject;
    private Optional<Float> score;
    
    public ScoreEntry(UniversitySubject subject, Float score) {
        this.subject = subject;
        this.score = Optional.ofNullable(score);
    }

    public UniversitySubject getSubject() {
        return subject;
    }

    public Optional<Float> getScore() {
        return score;
    }
    
    public void updateScore(float score) {
        this.score = Optional.of(score);
    }
    
    public String getSubjectId() {
        return subject.getSubjectId();
    }
}

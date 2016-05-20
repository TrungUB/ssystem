package th.system.domain;

import java.util.Optional;

import lombok.Getter;
import th.system.domain.subject.UniversitySubject;

public class ScoreEntry {

    @Getter
    private UniversitySubject subject;
    @Getter
    private Optional<Float> midtermScore;
    @Getter
    private Optional<Float> finalScore;
    
    public ScoreEntry(UniversitySubject subject, Float midtermScore, Float finalScore) {
        this.subject = subject;
        this.midtermScore = Optional.ofNullable(midtermScore);
        this.finalScore = Optional.ofNullable(finalScore);
    }
    
    public void updateScore(float midtermScore, float finalScore) {
        this.midtermScore = Optional.of(midtermScore);
        this.finalScore = Optional.of(finalScore);
    }
    
    public String getSubjectId() {
        return subject.getSubjectId();
    }
    
    public Optional<Double> getAverageScore() {
        if(midtermScore.isPresent() && finalScore.isPresent()) {
            return Optional.of(midtermScore.get() * 0.3 + finalScore.get() * 0.7);
        }
        
        return Optional.ofNullable(null);
    }
    
    public boolean isPass() {
        Optional<Double> averageScore = getAverageScore();
        return averageScore.isPresent() && averageScore.get() >= 4;
    }
}

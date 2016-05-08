package th.system.domain;

import java.util.Optional;

import th.system.domain.subject.UniversitySubject;

public class ScoreEntry {
    
    private UniversitySubject subject;
    private Optional<Float> midtermScore;
    private Optional<Float> finalScore;
    
    public ScoreEntry(UniversitySubject subject, Float midtermScore, Float finalScore) {
        this.subject = subject;
        this.midtermScore = Optional.ofNullable(midtermScore);
        this.finalScore = Optional.ofNullable(finalScore);
    }

    public UniversitySubject getSubject() {
        return subject;
    }

    public Optional<Float> getMidtermScore() {
        return midtermScore;
    }
    
    public Optional<Float> getFinalScore() {
        return finalScore;
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

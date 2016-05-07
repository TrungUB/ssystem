package th.system.domain.register;

import th.system.domain.ScoreEntry;
import th.system.domain.Student;
import th.system.domain.subject.ScheduledSubject;

public class ScheduledSubjectRegister extends SubjectRegister {
    
    public ScheduledSubjectRegister(Student student) {
        super(student);
    }
    
    @Override
    protected boolean isStatisfied(ScoreEntry entry) {
        return entry.getSubject() instanceof ScheduledSubject;
    }
    
}

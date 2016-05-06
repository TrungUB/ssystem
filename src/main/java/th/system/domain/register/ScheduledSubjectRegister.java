package th.system.domain.register;

import th.system.domain.ScheduledSubject;
import th.system.domain.ScoreEntry;
import th.system.domain.Student;

public class ScheduledSubjectRegister extends SubjectRegister{

    public ScheduledSubjectRegister(Student student) {
        super(student);
    }

    @Override
    protected boolean isStatisfied(ScoreEntry entry) {
        return entry.getSubject() instanceof ScheduledSubject;
    }

}

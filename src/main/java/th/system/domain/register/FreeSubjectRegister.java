package th.system.domain.register;

import th.system.domain.ScoreEntry;
import th.system.domain.Student;
import th.system.domain.subject.FreeRegisterSubject;

public class FreeSubjectRegister extends SubjectRegister {

    public FreeSubjectRegister(Student student) {
        super(student);
    }

    @Override
    protected boolean isStatisfied(ScoreEntry entry) {
        return entry.getSubject() instanceof FreeRegisterSubject;
    }

}

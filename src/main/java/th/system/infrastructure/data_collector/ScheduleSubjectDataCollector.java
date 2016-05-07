package th.system.infrastructure.data_collector;

import java.util.List;

import th.system.domain.subject.ScheduledSubject;
import th.system.domain.subject.UniversitySubject;

public class ScheduleSubjectDataCollector extends SubjectDataCollector {
    
    @Override
    protected UniversitySubject getASubject() {
        System.out.println("Please enter the subject ID: ");
        String subjectId = getTrimmedString();
        System.out.println("Please enter the subject name: ");
        String subjectName = getTrimmedString();
        System.out.println("Please enter the subject credit: ");
        int credit = getCredit();
        System.out.println("Please enter the subject semester: ");
        String semester = getTrimmedString();
        ScheduledSubject scheduledSubject = new ScheduledSubject(subjectId, subjectName, credit, semester);
        return scheduledSubject;
    }
    
    @Override
    protected List<? extends UniversitySubject> normalizeSubject(List<? extends UniversitySubject> subjects) {
        return subjects;
    }

    @Override
    protected void displayMessage() {
        System.out.println("Please enter the scheduled subject data.");
    }
}

package th.system.infrastructure.data_collector;

import java.util.List;

import th.system.domain.subject.ScheduledSubject;
import th.system.domain.subject.UniversitySubject;

public class ScheduleSubjectDataCollector extends SubjectDataCollector {
    
    @Override
    protected UniversitySubject getASubject() {
        return new ScheduledSubject(
            getString("Please enter the subject ID: "),
            getString("Please enter the subject name: "),
            getCredit("Please enter the subject credit: "),
            getString("Please enter the subject semester: "));
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

package th.system.infrastructure;

import java.util.ArrayList;
import java.util.List;

import th.system.domain.fcc.SubjectEntities;
import th.system.domain.subject.UniversitySubject;
import th.system.infrastructure.data_collector.FreeSubjectDataCollector;
import th.system.infrastructure.data_collector.ScheduleSubjectDataCollector;
import th.system.infrastructure.data_collector.SubjectDataCollector;

public class SubjectInfrastructure {
    
    private List<SubjectDataCollector> dataCollectors;
    
    public SubjectInfrastructure() {
        dataCollectors = new ArrayList<>();
        dataCollectors.add(new FreeSubjectDataCollector());
        dataCollectors.add(new ScheduleSubjectDataCollector());
    }

    public SubjectEntities fetchSubjectData() {
        List<UniversitySubject> result = new ArrayList<>();
        dataCollectors.forEach(e -> result.addAll(e.fetchSubjectData().getAll()));
        return new SubjectEntities(result);
    }
    
}

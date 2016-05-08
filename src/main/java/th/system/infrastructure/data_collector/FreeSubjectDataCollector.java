package th.system.infrastructure.data_collector;

import java.util.ArrayList;
import java.util.List;

import th.system.domain.fcc.SubjectEntities;
import th.system.domain.subject.FreeRegisterSubject;
import th.system.domain.subject.UniversitySubject;

public class FreeSubjectDataCollector extends SubjectDataCollector {
    
    @Override
    protected UniversitySubject getASubject() {
        return new UniversitySubject(
            getString("Please enter the subject ID: "),
            getString("Please enter the subject name: "),
            getCredit("Please enter the subject credit: "));
    }
    
    @Override
    protected List<? extends UniversitySubject> normalizeSubject(List<? extends UniversitySubject> listSubject) {
        System.out.println("Get the predetermine subject list for each subject");
        
        List<FreeRegisterSubject> freeRegisterSubjects = new ArrayList<>();
        SubjectEntities subjects = new SubjectEntities(listSubject);
        
        listSubject.forEach(e -> freeRegisterSubjects.add(FreeRegisterSubject.valueOf(e, getThePredetermineSubjectsOf(e, subjects))));
        return freeRegisterSubjects;
    }
    
    private SubjectEntities getThePredetermineSubjectsOf(UniversitySubject subject, SubjectEntities subjects) {
        System.out.println(String.format("[Subject id]: %s, [Subject name]: %s", subject.getSubjectId(), subject.getSubjectName()));
        List<UniversitySubject> predetermineList = new ArrayList<>();
        
        while (true) {
            String id = getString("Enter the pre-determine subject id (Press enter if there is no pre-determine subject): ");
            
            if(id.length() == 0) {
                break;
            }
            
            if (!subjects.doesExist(id)) {
                System.out.println(String.format("This subject (%s) does not exist. Do it again!", id));
            } else {
                predetermineList.add(subjects.findSubjectById(id));
            }
            
            if (!isContinue()) {
                break;
            }
        }
        
        return new SubjectEntities(predetermineList);
    }
    
    @Override
    protected void displayMessage() {
        System.out.println("Please enter the credit subject data.");
    }
}

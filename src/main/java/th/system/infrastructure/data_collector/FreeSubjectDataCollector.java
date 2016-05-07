package th.system.infrastructure.data_collector;

import java.util.ArrayList;
import java.util.List;

import th.system.domain.fcc.SubjectEntities;
import th.system.domain.subject.FreeRegisterSubject;
import th.system.domain.subject.UniversitySubject;

public class FreeSubjectDataCollector extends SubjectDataCollector {
    
    @Override
    protected UniversitySubject getASubject() {
        System.out.println("Please enter the subject ID: ");
        String subjectId = getTrimmedString();
        System.out.println("Please enter the subject name: ");
        String subjectName = getTrimmedString();
        System.out.println("Please enter the subject credit: ");
        int credit = getCredit();
        UniversitySubject universitySubject = new UniversitySubject(subjectId, subjectName, credit);
        return universitySubject;
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
        System.out.println(String.format("[Subject id]: %d, [Subject name]: %d", subject.getSubjectId(), subject.getSubjectName()));
        List<UniversitySubject> predetermineList = new ArrayList<>();
        
        while (true) {
            System.out.println("Enter the pre-determine subject id: ");
            String id = scanner.nextLine();
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

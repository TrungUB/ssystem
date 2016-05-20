package th.system.infrastructure.data_collector;

import java.util.ArrayList;
import java.util.List;

import th.system.domain.fcc.SubjectEntities;
import th.system.domain.subject.UniversitySubject;
import th.system.get_input.GetInputFromConsole;

public abstract class SubjectDataCollector {
    
    protected GetInputFromConsole scanner;
    
    public SubjectDataCollector() {
        scanner = new GetInputFromConsole();
    }
    
    public SubjectEntities fetchSubjectData() {
        List<UniversitySubject> subjects = new ArrayList<>();
        
        displayMessage();
        
        while (true) {
            subjects.add(getASubject());
            if (!isContinue()) {
                break;
            }
        }
        
        return new SubjectEntities(normalizeSubject(subjects));
    }
    
    protected abstract void displayMessage();
    
    protected abstract List<? extends UniversitySubject> normalizeSubject(List<? extends UniversitySubject> subjects);
    
    protected abstract UniversitySubject getASubject();
    
    protected boolean isContinue() {
        System.out.println("Do you want to enter one more subject? [y/n].");
        while (true) {
            String option = getTrimmedString().toLowerCase();
            if (option.equals("y")) return true;
            if (option.equals("n")) return false;
            System.out.println("Invalid input! Just enter 'y' or 'n'.");
        }
    }
    
    protected String getString(String message) {
        return scanner.getString(message);
    }
    
    protected String getTrimmedString() {
        return scanner.getTrimmedString();
    }
    
    protected int getCredit(String message) {
        System.out.println(message);
        int credit;
        while (true) {
            try {
                credit = Integer.parseInt(getTrimmedString());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid integer. Please enter just an integer!");
                continue;
            }
        }
        return credit;
    }
}

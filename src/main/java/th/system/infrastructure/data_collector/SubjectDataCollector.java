package th.system.infrastructure.data_collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import th.system.domain.fcc.SubjectEntities;
import th.system.domain.subject.UniversitySubject;

public abstract class SubjectDataCollector {
    
    protected Scanner scanner;
    
    public SubjectDataCollector() {
        scanner = new Scanner(System.in);
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
    
    protected String getTrimmedString() {
        return scanner.nextLine().trim();
    }

    protected int getCredit() {
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

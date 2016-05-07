package th.system.user_interface;

import java.util.Scanner;

import th.system.application.SubjectRegisterApplication;
import th.system.user_interface.constant.SubjectRegisterOption;

public class SubjectManagerFunction implements ConsoleInterfaceExecutable {
    
    private Scanner scanner;
    private SubjectRegisterApplication application;
    
    public SubjectManagerFunction() {
        application = new SubjectRegisterApplication();
        scanner = new Scanner(System.in);
    }
    
    @Override
    public void execute() {
        checkSubjectDataExistProcess();
        
        while (true) {
            switch (getOption()) {
                case REGISTER:
                    new RegisterStudentFunction().execute();
                    continue;
                case DISPLAY_REGISTERED_SUBJECTS:
                    application.getRegisterSubjects(getString("Please enter the student id: "));
                    continue;
                case DISPLAY_SCORES:
                    application.getAllScoreResult(getString("Please enter the student id: "));
                    continue;
                case BACK:
                    System.out.println("Back to the main menu!");
                    break;
                default:
                    System.out.println("Option is not supported! Please choose another option.");
                    continue;
            }
            break;
        }
    }
    
    private String getString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
    
    private void checkSubjectDataExistProcess() {
        System.out.println("Subject manager function.");
        if (application.hasNoSubject()) {
            System.out.println("You have no subject to register. So, please make a list of subjects first!");
            application.fetchSubjectData();
        }
    }
    
    private SubjectRegisterOption getOption() {
        displayConsole();
        try {
            return SubjectRegisterOption.getOptByValue(Integer.parseInt(getString("Please enter the option!")));
        } catch (NumberFormatException ex) {
            return SubjectRegisterOption.NOT_SUPPORT;
        }
    }
    
    private void displayConsole() {
        System.out.println("Subject manager function");
        System.out.println("1. Register");
        System.out.println("2. Display scores");
        System.out.println("3. Display registered subjects");
        System.out.println("4. Back to main menu");
    }
    
}

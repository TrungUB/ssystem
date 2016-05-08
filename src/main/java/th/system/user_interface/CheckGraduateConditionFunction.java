package th.system.user_interface;

import java.util.Scanner;

import th.system.application.SubjectRegisterApplication;

public class CheckGraduateConditionFunction implements ConsoleInterfaceExecutable {

    private Scanner scanner;
    private SubjectRegisterApplication application;
    
    public CheckGraduateConditionFunction() {
        scanner = new Scanner(System.in);
        application = new SubjectRegisterApplication();
    }
    
    @Override
    public void execute() {
        displayConsole();
        String studentId = getString("Please enter the student id: ");
        System.out.println(String.format("Student %s can%s graduate.", studentId, application.isConsideredGraduate(studentId) ? "" : " not"));
    }

    private String getString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
    
    private void displayConsole() {
        System.out.println("Check the graduate condition function.");
    }
}

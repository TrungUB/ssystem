package th.system.user_interface;

import java.util.Scanner;

import th.system.application.SubjectRegisterApplication;
import th.system.domain.constant.RegisterType;

public class ChooseCourseFunction implements ConsoleInterfaceExecutable {
    
    private Scanner scanner;
    private String studentId;
    private SubjectRegisterApplication application;
    
    public ChooseCourseFunction(String studentId) {
        this.studentId = studentId;
        scanner = new Scanner(System.in);
        application = new SubjectRegisterApplication();
    }

    @Override
    public void execute() {
        while (true) {
            RegisterType option = getOption();
            if (option == RegisterType.NOT_SUPPORT) {
                System.out.println("Invalid option!");
                continue;
            }
            
            application.chooseCourse(studentId, option);
            break;
        }
    }
    
    private void displayConsole() {
        System.out.println("Which course do you want to get in?");
        System.out.println("1. Free register");
        System.out.println("2. Scheduled register");
    }
    
    private RegisterType getOption() {
        displayConsole();
        try {
            return RegisterType.getOptByValue(Integer.parseInt(getString("Please enter your course: ")));
        } catch (NumberFormatException ex) {
            return RegisterType.NOT_SUPPORT;
        }
    }
    
    private String getString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
    
}

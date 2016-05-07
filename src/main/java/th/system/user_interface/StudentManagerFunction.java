package th.system.user_interface;

import java.util.Scanner;

import th.system.application.StudentManagerApplication;
import th.system.user_interface.constant.StudentManagerOption;

public class StudentManagerFunction implements ConsoleInterfaceExecutable {
    
    private StudentManagerApplication studentManagerApplication;
    private Scanner scanner;
    
    public StudentManagerFunction() {
        scanner = new Scanner(System.in);
        studentManagerApplication = new StudentManagerApplication();
    }
    
    @Override
    public void execute() {
        while (true) {
            switch (getOption()) {
                case DISPLAY:
                    studentManagerApplication.getStudentList();
                    continue;
                case ADD:
                    studentManagerApplication.addStudent();
                    continue;
                case DELETE:
                    studentManagerApplication.deleteStudent(getString("Please enter the string id you want to delete: "));
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
    
    private StudentManagerOption getOption() {
        displayConsole();
        try {
            return StudentManagerOption.getOptByValue(Integer.parseInt(getString("Please enter the option!")));
        } catch (NumberFormatException ex) {
            return StudentManagerOption.NOT_SUPPORT;
        }
    }
    
    private void displayConsole() {
        System.out.println("Student manager function");
        System.out.println("1. Display list students");
        System.out.println("2. Add student");
        System.out.println("3. Delete student");
        System.out.println("4. Edit student info");
        System.out.println("5. Back to main menu");
    }
    
}

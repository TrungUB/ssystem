package th.system.user_interface;

import java.util.Scanner;

import th.system.application.StudentManagerApplication;
import th.system.user_interface.constant.StudentManagerOption;

public class StudentManagerFunction implements FunctionExecutable {

    private StudentManagerApplication studentManagerApplication;
    private Scanner scanner;
    
    public StudentManagerFunction() {
        scanner = new Scanner(System.in); 
        studentManagerApplication = new StudentManagerApplication();
    }
    
    @Override
    public void execute() {
        while(true) {
            switch (getOption()) {
                case DISPLAY:
                    studentManagerApplication.getStudentList();
                    continue;
                case ADD:
                    studentManagerApplication.addStudent();
                    continue;
                case DELETE:
                    studentManagerApplication.deleteStudent(getTheDeleteId());
                    continue;
                case EDIT:
                    studentManagerApplication.getStudentList();
                    continue;
                case BACK:
                    System.out.println("Back to the main menu!");
                    break;
                default:
                    System.out.println("Option is not supported! Please choose another option.");
                    break;
            }
            break;
        }
    }

    private String getTheDeleteId() {
        System.out.println("Please enter the string id you want to delete: ");
        return scanner.nextLine();
    }

    /**
     * @return 
     * 
     */
    private StudentManagerOption getOption() {
        displayConsole();
        try {
           return StudentManagerOption.getOptByValue(Integer.parseInt(scanner.nextLine()));
        } catch(NumberFormatException ex) {
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
        System.out.println("Please enter the option!");
    }

}

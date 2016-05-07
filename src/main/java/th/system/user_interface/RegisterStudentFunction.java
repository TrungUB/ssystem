package th.system.user_interface;

import java.util.Scanner;

import th.system.application.SubjectRegisterApplication;

public class RegisterStudentFunction implements ConsoleInterfaceExecutable {

    private Scanner scanner;
    private SubjectRegisterApplication application;
    
    public RegisterStudentFunction() {
        scanner = new Scanner(System.in);
        application = new SubjectRegisterApplication();
    }
    
    @Override
    public void execute() {
        String id = getString("Please enter the student id");
        
        if(!application.doesStudentExist(id)) {
            System.out.println("The student does not exist");
            return;
        }
        
        if(application.isVeryFirstTimeRegister(id)) {
            new ChooseCourseFunction(id).execute();
        }
        application.register(id, getString("Please enter the subject id"));  
    }
    
    private String getString(String message) {
        System.out.println(message);
        return scanner.nextLine().trim();
    }

}

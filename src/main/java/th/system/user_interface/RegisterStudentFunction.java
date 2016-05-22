package th.system.user_interface;

import th.system.application.SubjectRegisterApplication;

public class RegisterStudentFunction extends AbstractConsoleInterface {

    private SubjectRegisterApplication application;
    
    public RegisterStudentFunction() {
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
    
    @Override
    protected void displayOption() {
        // Do nothing
    }

}

package th.system.user_interface;

import th.system.application.SubjectRegisterApplication;

public class CheckGraduateConditionFunction extends AbstractConsoleInterface {

    private SubjectRegisterApplication application;
    
    public CheckGraduateConditionFunction() {
        application = new SubjectRegisterApplication();
    }
    
    @Override
    public void execute() {
        displayOption();
        String studentId = getString("Please enter the student id: ");
        System.out.println(String.format("Student %s can%s graduate.", studentId, application.isConsideredGraduate(studentId) ? "" : " not"));
    }

    @Override
    protected void displayOption() {
        System.out.println("Check the graduate condition function.");
    }
}

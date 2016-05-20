package th.system.user_interface;

import th.system.application.SubjectRegisterApplication;
import th.system.domain.constant.RegisterType;

public class ChooseCourseFunction extends AbstractConsoleInterface {
    
    private String studentId;
    private SubjectRegisterApplication application;
    
    public ChooseCourseFunction(String studentId) {
        this.studentId = studentId;
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
    
    private RegisterType getOption() {
        displayOption();
        try {
            return RegisterType.getOptByValue(Integer.parseInt(getString("Please enter your course: ")));
        } catch (NumberFormatException ex) {
            return RegisterType.NOT_SUPPORT;
        }
    }

    @Override
    protected void displayOption() {
        System.out.println("Which course do you want to get in?");
        System.out.println("1. Free register");
        System.out.println("2. Scheduled register");
    }
    
}

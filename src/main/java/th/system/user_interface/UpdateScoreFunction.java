package th.system.user_interface;

import th.system.application.SubjectRegisterApplication;

public class UpdateScoreFunction extends AbstractConsoleInterface {
    
    private SubjectRegisterApplication application;
    
    public UpdateScoreFunction() {
        application = new SubjectRegisterApplication();
    }
    
    @Override
    public void execute() {
        displayOption();
        displayStudentList();
        String studentId = getString("Please enter the student id: ");
        if (!application.doesStudentExist(studentId)) {
            System.out.println("This student id does not exist");
            return;
        }
        
        displaySubjectList(studentId);
        String subjectId = getString("Please enter the subject id: ");
        if (!application.doesSubjectExist(studentId, subjectId)) {
            System.out.println(String.format("Student %s still doesn't register the subject %s.", studentId, subjectId));
            return;
        }
        application.updateScore(
            studentId,
            subjectId,
            getFloatInRange("Please enter the midterm score: ", 0, 10),
            getFloatInRange("Please enter the final score: ", 0, 10));
    }
    
    private float getFloatInRange(String message, int lower, int upper) {
        while (true) {
            try {
                float parsedFloat = Float.parseFloat(getString(message));
                if (parsedFloat >= lower && parsedFloat <= upper) {
                    return parsedFloat;
                }
                System.out.println(String.format("Out of range! Please enter a float between %d and %d.", lower, upper));
            } catch (NumberFormatException ex) {
                // Do nothing
            }
        }
    }
    
    protected void displaySubjectList(String studentId) {
        application.getRegisterSubjects(studentId);
    }
    
    private void displayStudentList() {
        application.displayAllStudentList();
    }
    
    @Override
    protected void displayOption() {
        System.out.println("Update score function.");
    }
    
}

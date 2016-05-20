package th.system.user_interface;

import java.io.Console;
import java.io.PrintStream;

import org.junit.Test;

import mockit.Mocked;
import mockit.StrictExpectations;
import th.system.application.SubjectRegisterApplication;

public class CheckGraduateConditionFunctionTest {
    
    @Test
    public void printConsoleTestWithOnly1Line(@Mocked PrintStream stream) throws Exception {
        CheckGraduateConditionFunction checkGraduateConditionFunction = new CheckGraduateConditionFunction();
        
        new StrictExpectations() {{
            System.out.println(anyString); maxTimes = 1;
        }};
        
        checkGraduateConditionFunction.displayOption();
    }
    
    @Test
    public void execute(@Mocked SubjectRegisterApplication application, @Mocked Console console) throws Exception {
        CheckGraduateConditionFunction checkGraduateConditionFunction = new CheckGraduateConditionFunction();
        String studentId = "hoge";
        
        new StrictExpectations(checkGraduateConditionFunction) {{
            checkGraduateConditionFunction.displayOption();
            checkGraduateConditionFunction.getString(anyString); result = studentId;
            application.isConsideredGraduate(studentId); result = true;
        }};
        
        checkGraduateConditionFunction.execute();
    }
}

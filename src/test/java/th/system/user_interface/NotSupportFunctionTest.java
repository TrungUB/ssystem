package th.system.user_interface;

import java.io.PrintStream;

import org.junit.Test;

import mockit.Mocked;
import mockit.StrictExpectations;

public class NotSupportFunctionTest {
    
    @Test
    public void executeWithOnlyOneLinePrintToConsole(@Mocked PrintStream stream) throws Exception {
        new StrictExpectations() {{
            System.out.println(anyString); maxTimes = 1;
        }};
        
        new NotSupportFunction().execute();
    }
}

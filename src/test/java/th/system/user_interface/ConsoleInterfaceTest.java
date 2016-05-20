package th.system.user_interface;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.PrintStream;

import org.junit.Test;

import mockit.Deencapsulation;
import mockit.Mocked;
import mockit.StrictExpectations;
import th.system.user_interface.constant.GlobalFunctionOption;

public class ConsoleInterfaceTest {

    @Test
    public void DisplayTheOptionToConsoleWith6Lines(@Mocked PrintStream printStream) {
        ConsoleInterface consoleInterface = new ConsoleInterface();
        
        new StrictExpectations() {{
            System.out.println(anyString); maxTimes = 6;
        }};
        
        consoleInterface.displayOption();
    }
    
    @Test
    public void executeWithExitOption() throws Exception {
        ConsoleInterface consoleInterface = new ConsoleInterface();
        GlobalFunctionOption option = GlobalFunctionOption.EXIT;
        
        new StrictExpectations(consoleInterface) {{
            Deencapsulation.invoke(consoleInterface, "getOptionFromConsole"); result = option;
            assertThat(option, is(GlobalFunctionOption.EXIT));
        }};
        
        consoleInterface.execute();
    }
    
    @Test
    public void executeWithNotSupportOption() throws Exception {
        ConsoleInterface consoleInterface = new ConsoleInterface();
        GlobalFunctionOption option = GlobalFunctionOption.NOT_SUPPORT;
        GlobalFunctionOption exit = GlobalFunctionOption.EXIT;
        
        new StrictExpectations(consoleInterface) {{
            Deencapsulation.invoke(consoleInterface, "getOptionFromConsole"); result = option;
            assertThat(option, is(not(GlobalFunctionOption.EXIT)));
            option.getCommand().execute();
            Deencapsulation.invoke(consoleInterface, "getOptionFromConsole"); result = exit;
            assertThat(exit, is(GlobalFunctionOption.EXIT));
        }};
        
        consoleInterface.execute();
    }
}

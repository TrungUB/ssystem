package th.system.get_input;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;

import org.junit.Test;

import mockit.Mock;
import mockit.MockUp;
import mockit.StrictExpectations;

public class GetInputFromConsoleTest {
    
    @Test
    public void getStringFromConsole() {
        GetInputFromConsole scanner = new GetInputFromConsole();
        String test = "123";
        
        new MockUp<Scanner>() {
            @Mock
            public String nextLine() {
                return test;
            }
        };
        
        assertThat(scanner.getTrimmedString(), is(test));
    }
    
    @Test
    public void getStringAndDisplayMessage() {
        GetInputFromConsole scanner = new GetInputFromConsole();
        String message = "Hello";
        String testRes = "124";
        
        new StrictExpectations(scanner) {{
            System.out.println(message);
            scanner.getTrimmedString(); result = testRes;
        }};
        
        assertThat(scanner.getString(message), is(testRes));
    }
}

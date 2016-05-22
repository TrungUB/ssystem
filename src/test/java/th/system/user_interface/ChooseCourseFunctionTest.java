package th.system.user_interface;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.PrintStream;

import org.junit.Test;

import mockit.Deencapsulation;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.StrictExpectations;
import th.system.application.SubjectRegisterApplication;
import th.system.domain.constant.RegisterType;

public class ChooseCourseFunctionTest {

    @Test
    public void displayOptionToConsoleWith3Lines(@Mocked PrintStream stream) throws Exception {
        new StrictExpectations() {{
            System.out.println(anyString); maxTimes = 3;
        }};
        
        new ChooseCourseFunction("hoge").displayOption();
    }
    
    @Test
    public void executeWithValidOption() throws Exception {
        ChooseCourseFunction chooseCourseFunction = new ChooseCourseFunction("hoge");
        RegisterType free = RegisterType.FREE;
        
        new MockUp<SubjectRegisterApplication>() {
            @Mock
            public void chooseCourse(String studentId, RegisterType type) {
                // Do nothing
            }
        };
        
        
        new StrictExpectations(chooseCourseFunction) {{
            Deencapsulation.invoke(chooseCourseFunction, "getOption"); result = free; 
            Deencapsulation.getField(chooseCourseFunction, SubjectRegisterApplication.class).chooseCourse(anyString, free);
        }};
        
        chooseCourseFunction.execute();
    }
    
    @Test
    public void executeWithInvalidOption() throws Exception {
        ChooseCourseFunction chooseCourseFunction = new ChooseCourseFunction("hoge");
        RegisterType notSupport = RegisterType.NOT_SUPPORT;
        RegisterType free = RegisterType.FREE;
        
        new MockUp<SubjectRegisterApplication>() {
           @Mock
           public void chooseCourse(String studentId, RegisterType type) {
               // Do nothing
           }
        };
        
        new StrictExpectations(chooseCourseFunction) {{
            Deencapsulation.invoke(chooseCourseFunction, "getOption"); result = notSupport;
            assertThat(notSupport, is(RegisterType.NOT_SUPPORT));
            Deencapsulation.invoke(chooseCourseFunction, "getOption"); result = free;
            assertThat(free, is(not(RegisterType.NOT_SUPPORT)));
            Deencapsulation.getField(chooseCourseFunction, SubjectRegisterApplication.class).chooseCourse(anyString, free);
        }};
        
        chooseCourseFunction.execute();
    }
    
}

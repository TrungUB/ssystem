package th.system.user_interface;

import java.io.PrintStream;

import org.junit.Test;

import mockit.Deencapsulation;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.StrictExpectations;
import th.system.application.StudentManagerApplication;
import th.system.user_interface.constant.StudentManagerOption;

public class StudentManagerFunctionTest {
    
    @Test
    public void printOutConsoleWithSixLines(@Mocked PrintStream stream) throws Exception {
        StudentManagerFunction studentManagerFunction = new StudentManagerFunction();
        
        new StrictExpectations(studentManagerFunction) {{
            System.out.println(anyString); maxTimes = 6;
        }};
        
        studentManagerFunction.displayOption();
    }
    
    @Test
    public void executeOptionOneOption_ThenBack(@Mocked PrintStream stream) throws Exception {
        StudentManagerFunction studentManagerFunction = new StudentManagerFunction();
        
        new MockUp<StudentManagerApplication>() {
            @Mock
            public void getStudentList() {
                // Do nothing
            }
        };
        
        new StrictExpectations(studentManagerFunction) {{
            Deencapsulation.invoke(studentManagerFunction, "getOption"); result = StudentManagerOption.DISPLAY;
            Deencapsulation.getField(studentManagerFunction, StudentManagerApplication.class).getStudentList();
            Deencapsulation.invoke(studentManagerFunction, "getOption"); result = StudentManagerOption.BACK;
            System.out.println(anyString); maxTimes = 1;
        }};
        
        studentManagerFunction.execute();
    }
    

    @Test
    public void executeOptionOptionTwo_ThenBack(@Mocked PrintStream stream) throws Exception {
        StudentManagerFunction studentManagerFunction = new StudentManagerFunction();
        
        new MockUp<StudentManagerApplication>() {
            @Mock
            public void addStudent() {
                // Do nothing
            }
        };
        
        new StrictExpectations(studentManagerFunction) {{
            Deencapsulation.invoke(studentManagerFunction, "getOption"); result = StudentManagerOption.ADD;
            Deencapsulation.getField(studentManagerFunction, StudentManagerApplication.class).addStudent();
            Deencapsulation.invoke(studentManagerFunction, "getOption"); result = StudentManagerOption.BACK;
            System.out.println(anyString); maxTimes = 1;
        }};
        
        studentManagerFunction.execute();
    }

    @Test
    public void executeOptionOptionThree_ThenBack(@Mocked PrintStream stream) throws Exception {
        StudentManagerFunction studentManagerFunction = new StudentManagerFunction();
        
        new MockUp<StudentManagerApplication>() {
            @Mock
            public void deleteStudent(String studentId) {
                // Do nothing
            }
        };
        
        new StrictExpectations(studentManagerFunction) {{
            Deencapsulation.invoke(studentManagerFunction, "getOption"); result = StudentManagerOption.DELETE;
            studentManagerFunction.getString(anyString); result = "hoge";
            Deencapsulation.getField(studentManagerFunction, StudentManagerApplication.class).deleteStudent("hoge");
            Deencapsulation.invoke(studentManagerFunction, "getOption"); result = StudentManagerOption.BACK;
            System.out.println(anyString); maxTimes = 1;
        }};
        
        studentManagerFunction.execute();
    }
    
    @Test
    public void executeOptionNotSupportOption_ThenBack(@Mocked PrintStream stream) throws Exception {
        StudentManagerFunction studentManagerFunction = new StudentManagerFunction();
        
        new StrictExpectations(studentManagerFunction) {{
            Deencapsulation.invoke(studentManagerFunction, "getOption"); result = StudentManagerOption.NOT_SUPPORT;
            System.out.println(anyString); maxTimes = 1;
            Deencapsulation.invoke(studentManagerFunction, "getOption"); result = StudentManagerOption.BACK;
            System.out.println(anyString); maxTimes = 1;
        }};
        
        studentManagerFunction.execute();
    }
}

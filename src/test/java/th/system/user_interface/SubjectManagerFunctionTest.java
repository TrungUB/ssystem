package th.system.user_interface;

import java.io.PrintStream;

import org.junit.Test;

import mockit.Deencapsulation;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.StrictExpectations;
import th.system.application.SubjectRegisterApplication;
import th.system.user_interface.constant.SubjectRegisterOption;

public class SubjectManagerFunctionTest {
    
    @Test
    public void displayOptionWithFiveLines(@Mocked PrintStream stream) throws Exception {
        SubjectManagerFunction subjectManagerFunction = new SubjectManagerFunction();
        
        new StrictExpectations(subjectManagerFunction) {{
            System.out.println(anyString); maxTimes = 5;
        }};
        
        subjectManagerFunction.displayOption();
    }
    
    @Test
    public void executeWithOptionOne_ThenBack(@Mocked PrintStream stream) throws Exception {
        SubjectManagerFunction subjectManagerFunction = new SubjectManagerFunction();
        
        new MockUp<RegisterStudentFunction>() {
            @Mock
            public void execute() {
                // Do nothing
            }
        };
        
        new StrictExpectations(subjectManagerFunction) {{
            Deencapsulation.invoke(subjectManagerFunction, "checkSubjectDataExistProcess");
            Deencapsulation.invoke(subjectManagerFunction, "getOption"); result = SubjectRegisterOption.REGISTER;
            new RegisterStudentFunction().execute();
            Deencapsulation.invoke(subjectManagerFunction, "getOption"); result = SubjectRegisterOption.BACK;
            System.out.println(anyString);
        }};
        
        subjectManagerFunction.execute();
    }

    @Test
    public void executeWithOptionTwo_ThenBack(@Mocked PrintStream stream) throws Exception {
        SubjectManagerFunction subjectManagerFunction = new SubjectManagerFunction();
        
        new MockUp<SubjectRegisterApplication>() {
            @Mock
            public void getRegisterSubjects(String studentId) {
                // Do nothing
            }
        };
        
        new StrictExpectations(subjectManagerFunction) {{
            Deencapsulation.invoke(subjectManagerFunction, "checkSubjectDataExistProcess");
            Deencapsulation.invoke(subjectManagerFunction, "getOption"); result = SubjectRegisterOption.DISPLAY_REGISTERED_SUBJECTS;
            subjectManagerFunction.getString(anyString); result = "hoge";
            Deencapsulation.getField(subjectManagerFunction, SubjectRegisterApplication.class).getRegisterSubjects("hoge");
            Deencapsulation.invoke(subjectManagerFunction, "getOption"); result = SubjectRegisterOption.BACK;
            System.out.println(anyString);
        }};
        
        subjectManagerFunction.execute();
    }

    @Test
    public void executeWithOptionThree_ThenBack(@Mocked PrintStream stream) throws Exception {
        SubjectManagerFunction subjectManagerFunction = new SubjectManagerFunction();
        
        new MockUp<SubjectRegisterApplication>() {
            @Mock
            public void getAllScoreResult(String studentId) {
                // Do nothing
            }
        };
        
        new StrictExpectations(subjectManagerFunction) {{
            Deencapsulation.invoke(subjectManagerFunction, "checkSubjectDataExistProcess");
            Deencapsulation.invoke(subjectManagerFunction, "getOption"); result = SubjectRegisterOption.DISPLAY_SCORES;
            subjectManagerFunction.getString(anyString); result = "hoge";
            Deencapsulation.getField(subjectManagerFunction, SubjectRegisterApplication.class).getAllScoreResult("hoge");
            Deencapsulation.invoke(subjectManagerFunction, "getOption"); result = SubjectRegisterOption.BACK;
            System.out.println(anyString);
        }};
        
        subjectManagerFunction.execute();
    }

    @Test
    public void executeWithNotSupportOption_ThenBack(@Mocked PrintStream stream) throws Exception {
        SubjectManagerFunction subjectManagerFunction = new SubjectManagerFunction();
        
        new StrictExpectations(subjectManagerFunction) {{
            Deencapsulation.invoke(subjectManagerFunction, "checkSubjectDataExistProcess");
            Deencapsulation.invoke(subjectManagerFunction, "getOption"); result = SubjectRegisterOption.NOT_SUPPORT;
            System.out.println(anyString);
            Deencapsulation.invoke(subjectManagerFunction, "getOption"); result = SubjectRegisterOption.BACK;
            System.out.println(anyString);
        }};
        
        subjectManagerFunction.execute();
    }
}

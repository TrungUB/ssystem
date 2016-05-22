package th.system.user_interface;

import org.junit.Test;

import mockit.Deencapsulation;
import mockit.Mock;
import mockit.MockUp;
import mockit.StrictExpectations;
import th.system.application.SubjectRegisterApplication;

public class RegisterStudentFunctionTest {
    
    @Test
    public void executeWithNotExistStudent() throws Exception {
        RegisterStudentFunction registerStudentFunction = new RegisterStudentFunction();
        
        new StrictExpectations(registerStudentFunction) {{
            registerStudentFunction.getString(anyString); result = "hoge";
            Deencapsulation.getField(registerStudentFunction, SubjectRegisterApplication.class).doesStudentExist("hoge"); result = false;
        }};
        
        registerStudentFunction.execute();
    }
    
    @Test
    public void executeWithAnExistFirstTimeRegisterStudent() throws Exception {
        RegisterStudentFunction registerStudentFunction = new RegisterStudentFunction();
        String studentId = "hoge";
        String subjectId = "subject";
        
        new MockUp<ChooseCourseFunction>() {
            @Mock
            public void execute() {
                // Do nothing
            }
        };
        
        new MockUp<SubjectRegisterApplication>() {
            @Mock
            public void register(String id, String subject) {
                // Do nothing
            }
        };
        
        new StrictExpectations(registerStudentFunction) {{
            registerStudentFunction.getString(anyString); result = studentId;
            Deencapsulation.getField(registerStudentFunction, SubjectRegisterApplication.class).doesStudentExist(studentId); result = true;
            Deencapsulation.getField(registerStudentFunction, SubjectRegisterApplication.class).isVeryFirstTimeRegister(studentId); result = true;
            new ChooseCourseFunction(studentId).execute();
            Deencapsulation.getField(registerStudentFunction, SubjectRegisterApplication.class).register(studentId, subjectId);
        }};
        
        registerStudentFunction.execute();
    }
    
    @Test
    public void executeWithAlreadyRegisterdStudent() throws Exception {
        RegisterStudentFunction registerStudentFunction = new RegisterStudentFunction();
        String studentId = "hoge";
        String subjectId = "subject";
        
        new MockUp<ChooseCourseFunction>() {
            @Mock
            public void execute() {
                // Do nothing
            }
        };
        
        new MockUp<SubjectRegisterApplication>() {
            @Mock
            public void register(String id, String subject) {
                // Do nothing
            }
        };
        
        new StrictExpectations(registerStudentFunction) {{
            registerStudentFunction.getString(anyString); result = studentId;
            Deencapsulation.getField(registerStudentFunction, SubjectRegisterApplication.class).doesStudentExist(studentId); result = true;
            Deencapsulation.getField(registerStudentFunction, SubjectRegisterApplication.class).isVeryFirstTimeRegister(studentId); result = false;
            Deencapsulation.getField(registerStudentFunction, SubjectRegisterApplication.class).register(studentId, subjectId);
        }};
        
        registerStudentFunction.execute();
    }
}

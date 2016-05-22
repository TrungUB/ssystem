package th.system.user_interface;

import java.io.PrintStream;

import org.junit.Test;

import mockit.Deencapsulation;
import mockit.Mocked;
import mockit.StrictExpectations;
import th.system.application.SubjectRegisterApplication;

public class UpdateScoreFunctionTest {

    @Test
    public void displayOptionWithOneLine(@Mocked PrintStream stream) throws Exception {
        UpdateScoreFunction updateScoreFunction = new UpdateScoreFunction();
        
        new StrictExpectations() {{
            System.out.println(anyString); maxTimes = 1;
        }};
        updateScoreFunction.displayOption();
    }
    
    @Test
    public void executeWithNotExistStudent(@Mocked PrintStream stream) throws Exception {
        UpdateScoreFunction updateScoreFunction = new UpdateScoreFunction();
        
        new StrictExpectations(updateScoreFunction) {{
            Deencapsulation.invoke(updateScoreFunction, "displayOption");
            Deencapsulation.invoke(updateScoreFunction, "displayStudentList");
            updateScoreFunction.getString(anyString); result = "hoge";
            Deencapsulation.getField(updateScoreFunction, SubjectRegisterApplication.class).doesStudentExist("hoge"); result = false;
            System.out.println(anyString);
        }};
        
        updateScoreFunction.execute();
    }

    @Test
    public void executeWithExistStudent_ButNotExistSubject(@Mocked PrintStream stream) throws Exception {
        UpdateScoreFunction updateScoreFunction = new UpdateScoreFunction();
        
        new StrictExpectations(updateScoreFunction) {{
            Deencapsulation.invoke(updateScoreFunction, "displayOption");
            Deencapsulation.invoke(updateScoreFunction, "displayStudentList");
            updateScoreFunction.getString(anyString); result = "hoge";
            Deencapsulation.getField(updateScoreFunction, SubjectRegisterApplication.class).doesStudentExist("hoge"); result = true;
//            Deencapsulation.invoke(updateScoreFunction, "displaySubjectList", "hoge");
            updateScoreFunction.displaySubjectList("hoge");
//            updateScoreFunction.getString(anyString); result = "subject";
//            Deencapsulation.getField(updateScoreFunction, SubjectRegisterApplication.class).doesSubjectExist("hoge", "subject"); result = false;
            // System.out.println(anyString);
        }};
        
        updateScoreFunction.execute();
    }
}

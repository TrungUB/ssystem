package th.system.user_interface.constant;

import java.util.Arrays;
import java.util.List;

import th.system.user_interface.CheckGraduateConditionFunction;
import th.system.user_interface.ConsoleInterfaceExecutable;
import th.system.user_interface.NotSupportFunction;
import th.system.user_interface.NullFunction;
import th.system.user_interface.StudentManagerFunction;
import th.system.user_interface.SubjectManagerFunction;
import th.system.user_interface.UpdateScoreFunction;

public enum GlobalFunctionOption {
    // @formatter:off
    STUDENT_MANAGE          (1, new StudentManagerFunction()), 
    SUBJECT_REGISTER        (2, new SubjectManagerFunction()),
    FILL_RESULT             (3, new UpdateScoreFunction()), 
    CHECK_GRADUATE_CONDITION(4, new CheckGraduateConditionFunction()),
    EXIT                    (5, new NullFunction()), 
    NOT_SUPPORT             (0, new NotSupportFunction());
    // @formatter:on
    
    private int inputOpt;
    private ConsoleInterfaceExecutable command;
    
    GlobalFunctionOption(int number, ConsoleInterfaceExecutable command) {
        this.inputOpt = number;
        this.command = command;
    }
    
    public int getInputOpt() {
        return inputOpt;
    }
    
    public static List<GlobalFunctionOption> getGlobalFunctionOptionList() {
        return Arrays.asList(values());
    }
    
    public static GlobalFunctionOption getOptionFromInputOpt(int number) {
        return getGlobalFunctionOptionList().stream().filter(e -> e.inputOpt == number).findFirst().orElse(NOT_SUPPORT);
    }
    
    public ConsoleInterfaceExecutable getCommand() {
        return command;
    }
}

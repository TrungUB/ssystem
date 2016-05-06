package th.system.user_interface.constant;

import java.util.Arrays;
import java.util.List;

import th.system.application.ApplicationExecutable;
import th.system.application.NotSupportApplication;
import th.system.application.NullObjectApplication;
import th.system.application.StudentManagerApplication;

public enum GlobalFunctionOption {
    // @formatter:off
    STUDENT_MANAGE          (1, new StudentManagerApplication()), 
    SUBJECT_REGISTER        (2, new NullObjectApplication()),
    FILL_RESULT             (3, new NullObjectApplication()), 
    CHECK_GRADUATE_CONDITION(4, new NullObjectApplication()),
    EXIT                    (5, new NullObjectApplication()), 
    NOT_SUPPORT             (0, new NotSupportApplication());
    // @formatter:on
    
    private int inputOpt;
    private ApplicationExecutable command;
    
    GlobalFunctionOption(int number, ApplicationExecutable command) {
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
    
    public ApplicationExecutable getCommand() {
        return command;
    }
}

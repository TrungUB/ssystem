package th.system.user_interface.constant;

import java.util.Arrays;
import java.util.List;

public enum SubjectRegisterOption {
    REGISTER(1),
    DISPLAY_SCORES(2),
    DISPLAY_REGISTERED_SUBJECTS(3),
    BACK(4),
    NOT_SUPPORT(0);
    
    private int inputOpt;

    private SubjectRegisterOption(int inputOpt) {
        this.inputOpt = inputOpt;
    }
    
    public int getInputOpt() {
        return inputOpt;
    }
    
    public static List<SubjectRegisterOption> getOptList() {
        return Arrays.asList(values());
    }

    public static SubjectRegisterOption getOptByValue(int inputOpt) {
        return getOptList().stream().filter(e -> e.inputOpt == inputOpt).findFirst().orElse(NOT_SUPPORT);
    }
}

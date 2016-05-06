package th.system.user_interface.constant;

import java.util.Arrays;
import java.util.List;

public enum StudentManagerOption {
    DISPLAY(1),
    ADD(2),
    DELETE(3),
    EDIT(4),
    BACK(5),
    NOT_SUPPORT(6);
    
    private int inputOpt;

    private StudentManagerOption(int inputOpt) {
        this.inputOpt = inputOpt;
    }

    public int getInputOpt() {
        return inputOpt;
    }
    
    public static List<StudentManagerOption> getOptList() {
        return Arrays.asList(values());
    }

    public static StudentManagerOption getOptByValue(int inputOpt) {
        return getOptList().stream().filter(e -> e.inputOpt == inputOpt).findFirst().orElse(NOT_SUPPORT);
    }
}

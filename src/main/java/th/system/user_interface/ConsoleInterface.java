package th.system.user_interface;

import th.system.user_interface.constant.GlobalFunctionOption;

public class ConsoleInterface extends AbstractConsoleInterface {

    @Override
    protected void displayOption() {
        System.out.println("1. Student manage");
        System.out.println("2. Subject register");
        System.out.println("3. Update scores");
        System.out.println("4. Check the graduate condition");
        System.out.println("5. Exit");
        System.out.println("Which option do you want to choose?");
    }
    
    private GlobalFunctionOption getOptionFromConsole() {
        displayOption();
        try {
            return GlobalFunctionOption.getOptionFromInputOpt(Integer.parseInt(scanner.getTrimmedString()));
        } catch (NumberFormatException ex) {
            return GlobalFunctionOption.NOT_SUPPORT;
        }
    }
    
    @Override
    public void execute() {
        while(true) {
            GlobalFunctionOption optionFromConsole = getOptionFromConsole();
            if(optionFromConsole == GlobalFunctionOption.EXIT) {
                break;
            }
            
            optionFromConsole.getCommand().execute();
        }
    }
}

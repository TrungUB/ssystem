package th.system.user_interface;

import th.system.get_input.GetInputFromConsole;

public abstract class AbstractConsoleInterface implements ConsoleInterfaceExecutable {
    
    protected GetInputFromConsole scanner;

    public AbstractConsoleInterface() {
        scanner = new GetInputFromConsole();
    }
    
    protected abstract void displayOption();

    protected String getString(String message) {
        return scanner.getString(message);
    }
}

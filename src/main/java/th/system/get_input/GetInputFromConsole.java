package th.system.get_input;

import java.util.Scanner;

public class GetInputFromConsole {
    
    private Scanner scanner;
    
    public GetInputFromConsole() {
        scanner = new Scanner(System.in);
    }
    
    public String getString(String message) {
        System.out.println(message);
        return getTrimmedString();
    }
    
    public String getTrimmedString() {
        return scanner.nextLine().trim();
    }
}

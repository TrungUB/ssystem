package th.system.user_interface;

public class NotSupportFunction implements FunctionExecutable {
    
    @Override
    public void execute() {
        System.out.println("This option is not supported. Please choose another option!");        
    }
    
}

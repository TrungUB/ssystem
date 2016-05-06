package th.system.application;

public class NotSupportApplication implements ApplicationExecutable {
    
    @Override
    public void execute() {
        System.out.println("This option is not supported. Please choose another option!");        
    }
    
}

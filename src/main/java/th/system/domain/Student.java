package th.system.domain;

public class Student {
    
    private String name;
    private String className;
    
    public Student(String name, String className) {
        this.name = name;
        this.className = className;
    }
    
    public String getName() {
        return name;
    }
    
    public String getClassName() {
        return className;
    }
    
}

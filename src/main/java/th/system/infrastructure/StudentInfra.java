package th.system.infrastructure;

import java.util.Scanner;

import th.system.domain.Student;

public class StudentInfra {
    
    private Scanner scanner;
    
    public StudentInfra() {
        scanner = new Scanner(System.in);
    }
    
    public Student addStudent() {
        return getStudentInfo();
    }
    
    private Student getStudentInfo() {
        displayConsole();
        return new Student(getStringFromStdin("Please enter the student id: "), getStringFromStdin("Please enter the student name: "));
    }
    
    private String getStringFromStdin(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
    
    private void displayConsole() {
        System.out.println("Please enter the student information.");
    }
    
}

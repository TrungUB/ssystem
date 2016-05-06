package th.system.application;

import th.system.domain.Student;
import th.system.repository.StudentRepository;

public class StudentManagerApplication {
    
    private StudentRepository repository;
    
    public StudentManagerApplication() {
        repository = new StudentRepository();
    }
    
    public void getStudentList() {
        System.out.println("The student list: ");
        repository.getStudentList().getAll().stream().map(Student::getName).forEach(System.out::println);
    }
    
    public void addStudent() {
        System.out.println("The student list after adding one more student: ");
        repository.addStudent().getAll().stream().map(Student::getName).forEach(System.out::println);
    }

    public void deleteStudent(String id) {
        System.out.println("Delete student: ");
        repository.deleteStudent(id).getAll().stream().map(Student::getName).forEach(System.out::println);
    }
}

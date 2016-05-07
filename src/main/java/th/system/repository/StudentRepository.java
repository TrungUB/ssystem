package th.system.repository;

import th.system.domain.Student;
import th.system.domain.fcc.StudentEntities;
import th.system.infrastructure.StudentInfra;

public class StudentRepository {
    
    private StudentInfra studentInfra;
    private static StudentEntities studentList;
    
    public StudentRepository() {
        if (studentList == null) {
            studentList = new StudentEntities(null);
        }
        studentInfra = new StudentInfra();
    }
    
    public StudentEntities getStudentList() {
        return studentList;
    }
    
    public StudentEntities addStudent() {
        return studentList.addStudent(studentInfra.addStudent());
    }
    
    public StudentEntities deleteStudent(String id) {
        return studentList.deleteStudent(id);
    }
    
    public Student getStudent(String id) {
        return studentList.getStudentById(id);
    }

    public boolean doesStudentExist(String id) {
        return studentList.doesStudentExist(id);
    }
    
}

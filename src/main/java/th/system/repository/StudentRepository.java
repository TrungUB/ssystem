package th.system.repository;

import th.system.domain.fcc.Students;
import th.system.infrastructure.StudentInfra;

public class StudentRepository {

    private StudentInfra studentInfra;
    private static Students studentList = new Students(null);
    
    public StudentRepository() {
        studentInfra = new StudentInfra();
    }
    
    public Students getStudentList() {
        return studentList;
    }

    public Students addStudent() {
        return studentList.addStudent(studentInfra.addStudent());
    }

    public Students deleteStudent(String id) {
        return studentList.deleteStudent(id);
    }
    
}

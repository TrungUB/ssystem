package th.system.domain.fcc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import th.system.domain.Student;

public class Students {
    private List<Student> studentList;
    
    public Students(List<Student> studentList) {
        this.studentList = studentList == null ? new ArrayList<>() : new ArrayList<>(studentList);
    }
    
    public List<Student> getAll() {
        return new ArrayList<>(studentList);
    }
    
    public Students addStudent(Student student) {
        studentList.add(student);
        return new Students(studentList);
    }

    public Students deleteStudent(String id) {
        studentList = studentList.stream().filter(e -> !e.getId().equals(id.trim())).collect(Collectors.toList());
        return this;
    }
}

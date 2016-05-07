package th.system.domain.fcc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import th.system.domain.Student;

public class StudentEntities {
    private Map<String, Student> studentMap;
    
    public StudentEntities(List<Student> studentList) {
        this.studentMap = new HashMap<>();
        if(studentList != null) {
            studentList.forEach(e -> addStudent(e));
        }
    }
    
    public List<Student> getAll() {
        return new ArrayList<>(studentMap.values());
    }
    
    public StudentEntities addStudent(Student student) {
        studentMap.put(student.getId(), student);
        return this;
    }
    
    public StudentEntities deleteStudent(String id) {
        studentMap.remove(id);
        return this;
    }
    
    public Student getStudentById(String id) {
        return studentMap.get(id);
    }

    public boolean doesStudentExist(String id) {
        return studentMap.containsKey(id);
    }
}

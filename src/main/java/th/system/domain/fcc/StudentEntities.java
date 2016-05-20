package th.system.domain.fcc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import th.system.domain.Student;

public class StudentEntities implements Entities<Student> {

    private Map<String, Student> studentMap;
    
    public StudentEntities(List<Student> studentList) {
        this.studentMap = new HashMap<>();
        if(studentList != null) {
            studentList.forEach(e -> add(e));
        }
    }
    
    @Override
    public List<Student> getAll() {
        return new ArrayList<>(studentMap.values());
    }
    
    @Override
    public StudentEntities add(Student student) {
        studentMap.put(student.getId(), student);
        return this;
    }
    
    @Override
    public StudentEntities delete(String id) {
        studentMap.remove(id);
        return this;
    }
    
    @Override
    public Student findById(String id) {
        return studentMap.get(id);
    }

    @Override
    public boolean contains(String id) {
        return studentMap.containsKey(id);
    }

    @Override
    public boolean isEmpty() {
        return studentMap.isEmpty();
    }

}

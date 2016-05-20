package th.system.domain.fcc;

import java.util.List;

public interface Entities<T> {
    
    List<T> getAll();
    
    Entities<T> add(T object);
    
    boolean isEmpty();
    
    boolean contains(String id);
    
    T findById(String id);
    
    Entities<T> delete(String id);
}

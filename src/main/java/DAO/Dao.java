package DAO;

import java.util.List;

public interface Dao<T> {
    
    T get(int id);
    
    List<T> getAll();
    
    void save(T t);
    
    void update(int i);
    
    void delete(T t);
}

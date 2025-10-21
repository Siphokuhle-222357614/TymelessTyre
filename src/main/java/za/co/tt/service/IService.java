package za.co.tt.service;

// ...existing code...
import java.util.List;

public interface IService <T, ID>{
    T save(T entity);
    T update(T entity);
    void deleteById(ID id);
    T read(ID id);
    List<T> findAll();
}
package za.co.tt.service;

import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IService <T, ID>{
    T save(T entity);
    T update(T entity);
    ResponseEntity<?> deleteById(ID id);  // More generic return type
    T read(ID id);
    List<T> findAll();
}
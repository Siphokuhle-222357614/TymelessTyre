package za.co.tt.service;

import org.springframework.http.ResponseEntity;
import za.co.tt.domain.Cart;

import java.util.List;

public interface IService <T, ID>{

    T save(T entity);
    T update(T enity);
    ResponseEntity<Cart> deleteById(ID id);
    T read(ID id);
    List<T> findAll();

}

package za.co.tt.service;

import org.springframework.http.ResponseEntity;
import za.co.tt.domain.Cart;

import java.util.List;

public interface IService <T, ID>{

    T save(T entity);
    T update(T entity);
    //ResponseEntity<Cart>  //whoever created this is causing problems for other classes.
    ResponseEntity<Cart> deleteById(ID id);
    T read(ID id);
    List<T> findAll();

}

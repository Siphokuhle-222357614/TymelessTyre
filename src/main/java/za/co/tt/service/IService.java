package za.co.tt.service;

import java.util.List;

public interface IService <T, ID>{

    T save(T entity);
    T update(T enity);
    void deleteById(ID id);
    T read(ID userId);
    List<T> findAll();
}

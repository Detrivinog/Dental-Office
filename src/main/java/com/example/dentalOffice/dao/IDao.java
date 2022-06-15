package com.example.dentalOffice.dao;

import java.util.List;

public interface IDao<T>{
    T set(T t);
    T update(T t);
    T get(Long id);
    void delete(Long id);
    List<T> getAll();
}

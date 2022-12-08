package com.sparta.interfaces;

import java.util.List;

public interface DAO<T> {

    T findById (int id);

    int insert(T newRow);

    void delete(int id);

    void update(T update);

    List<T> findAll();
}
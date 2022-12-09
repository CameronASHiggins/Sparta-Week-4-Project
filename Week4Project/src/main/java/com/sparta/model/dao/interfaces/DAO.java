package com.sparta.model.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> extends AutoCloseable{

    int insert(T newEmployee) throws SQLException;
    T findByID(int id) throws SQLException;
    void update(T updateEmployee) throws SQLException;
    void delete(int id) throws SQLException;
    List<T> findAll() throws SQLException;
}

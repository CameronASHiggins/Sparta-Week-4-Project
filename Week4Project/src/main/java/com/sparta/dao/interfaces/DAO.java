package com.sparta.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> extends AutoCloseable{

    int insert(T newEmployee) throws SQLException;
    T findByID(int id) throws SQLException;
    void update(T updateEmployee) throws SQLException;
    void delete(int id) throws SQLException;
    List<T> findAll() throws SQLException;//I added these in mine didnt I? Are you pulling upstream from dev? weird
}

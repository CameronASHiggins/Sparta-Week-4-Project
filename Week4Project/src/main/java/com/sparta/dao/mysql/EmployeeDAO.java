package com.sparta.dao.mysql;

import com.sparta.dao.interfaces.DAO;
import com.sparta.entities.Employee;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeDAO implements DAO<Employee> {

    private static Connection connection = null;

    private static EmployeeDAO instance = null;

    private EmployeeDAO(){}

    public static EmployeeDAO getInstance(){
        if (instance == null){
            instance = new EmployeeDAO();
        }
        if (connection == null){
            Properties properties = new Properties();
            try {
                properties.load(new FileReader("dbconnect.properties"));
                connection = DriverManager.getConnection(
                        properties.getProperty("mysql.url"),
                        properties.getProperty("mysql.username"),
                        properties.getProperty("mysql.password"));
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return instance;
    }

    @Override
    public int insert(Employee newEmployee) throws SQLException {
        return 0;
    }

    @Override
    public Employee findByID(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Employee updateEmployee) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> list = new ArrayList<>();
        ResultSet rs = (connection.createStatement()).executeQuery
                ("SELECT * FROM employees");
        while(rs.next()){
            list.add(new Employee(rs.getString("emp_no"),
                    rs.getString("birth_date"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("gender"),
                    rs.getString("hire_date")));
        }
        return list;
    }

    @Override
    public void close(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

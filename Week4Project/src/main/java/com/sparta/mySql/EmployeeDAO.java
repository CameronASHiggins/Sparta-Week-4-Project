package com.sparta.mySql;

import com.sparta.Employee;
import com.sparta.interfaces.DAO;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class EmployeeDAO implements DAO<Employee>, AutoCloseable{

    private static Connection connection = null;
    private EmployeeDAO(){}
    private static EmployeeDAO DAOInstance = null;

    // Can initialise private static prepared statements here


    public static EmployeeDAO getInstance() throws SQLException{
        if(DAOInstance == null){ // Check if the Employee Data Access Object has been initialised
            DAOInstance = new EmployeeDAO(); // If it hasn't, then create it.
        }
        if(connection == null){
            Properties properties = new Properties();
            try {
                properties.load(new FileReader("dbconnect.properties"));
                connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("pass"));
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        }

        //Prepared statements can go down here

        return DAOInstance;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public int insert(Employee newRow) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Employee update) {

    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}

package com.sparta.model.dao.mysql;


import com.sparta.model.dao.interfaces.DAO;
import com.sparta.model.entities.Employee;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeDAO implements DAO<Employee> {

    private static Connection connection = null;

    private static EmployeeDAO instance = null;

    private static PreparedStatement findByIdPS = null;
    private static PreparedStatement deleteByIdPS = null;
    private static PreparedStatement insertEmployeePS = null;
    private static PreparedStatement updateEmployeePS = null;


    private EmployeeDAO(){}

    public static EmployeeDAO getInstance(){
        if (instance == null){
            instance = new EmployeeDAO();
        }
        if (connection == null){
            Properties properties = new Properties();
            try {
                properties.load(new FileReader("src/main/resources/dbconnect.properties"));
                connection = DriverManager.getConnection(
                        properties.getProperty("mysql.url"),
                        properties.getProperty("mysql.username"),
                        properties.getProperty("mysql.password"));
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(findByIdPS == null){
            try {
                findByIdPS = connection.prepareStatement("SELECT * FROM employees WHERE emp_no = ?");
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        if(deleteByIdPS == null){
            try {
                deleteByIdPS = connection.prepareStatement("DELETE FROM employees WHERE emp_no = ?");
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        if(insertEmployeePS == null){
            try {
                insertEmployeePS = connection.prepareStatement("INSERT INTO employees (emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES (?,?,?,?,?,?)");
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        if(updateEmployeePS == null){
            try {
                updateEmployeePS = connection.prepareStatement("UPDATE employees SET birth_date = ?, first_name = ?,last_name = ?, gender = ?, hire_date = ? WHERE emp_no = ?");
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

    @Override
    public int insert(Employee newEmployee) throws SQLException {
        int result = 0;
        int id = newEmployee.getEmpNo();
        String firstName = newEmployee.getFirstName();
        String lastName = newEmployee.getLastName();
        String birthDate = newEmployee.getBirthDate();
        String gender = newEmployee.getGender();
        String hireDate = newEmployee.getHireDate();
        try {
            insertEmployeePS.setInt(1,id);
            insertEmployeePS.setString(2,birthDate);
            insertEmployeePS.setString(3,firstName);
            insertEmployeePS.setString(4,lastName);
            insertEmployeePS.setString(5,gender);
            insertEmployeePS.setString(6,hireDate);

            result = insertEmployeePS.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("You are trying to insert an employee with a duplicate emp_no.\nIf you want to change this employee's details, use the update method");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public Employee findByID(int id) throws SQLException {
        Employee result = null;

        try {
            findByIdPS.setInt(1,id);
            ResultSet rs = findByIdPS.executeQuery();
            while(rs.next()) {
                result = new Employee(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void update(Employee updateEmployee) throws SQLException {
        //takes an employee with the with new information as values for their properties but the original emp_no (id) uses the emp_no
        int id = updateEmployee.getEmpNo();
        String birthDate = updateEmployee.getBirthDate();
        String firstName = updateEmployee.getFirstName();
        String lastName = updateEmployee.getLastName();
        String gender = updateEmployee.getGender();
        String hireDate = updateEmployee.getHireDate();
        //UPDATE employees SET birth_date = ?, first_name = ?,last_name = ?, gender = ?, hire_date = ? WHERE emp_no = ?
        try {

            updateEmployeePS.setString(1,birthDate);
            updateEmployeePS.setString(2,firstName);
            updateEmployeePS.setString(3,lastName);
            updateEmployeePS.setString(4,gender);
            updateEmployeePS.setString(5,hireDate);
            updateEmployeePS.setInt(6,id);

            updateEmployeePS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            deleteByIdPS.setInt(1,id);
            deleteByIdPS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> list = new ArrayList<>();
        ResultSet rs = (connection.createStatement()).executeQuery
                ("SELECT * FROM employees");
        while(rs.next()){
            list.add(new Employee(rs.getInt("emp_no"),
                    rs.getString("birth_date"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("gender"),
                    rs.getString("hire_date")));
        }
        return list;
    }

    public List<Employee> getEmployeeByStartAndEnd(String dept, String start, String end) throws SQLException{
        List<Employee> list = new ArrayList<>();
        ResultSet rs = (connection.createStatement()).executeQuery
                (   "SELECT employees.emp_no, departments.dept_name, employees.birth_date, employees.first_name, employees.last_name, employees.gender, employees.hire_date, dept_emp.from_date, dept_emp.to_date " +
                        "FROM employees " +
                        "JOIN dept_emp ON employees.emp_no = dept_emp.emp_no " +
                        "JOIN departments ON dept_emp.dept_no = departments.dept_no " +
                        "WHERE dept_emp.from_date > '" + start + "' AND dept_emp.to_date < '" + end + "' AND departments.dept_name = '" + dept + "'");
        while(rs.next()){
            list.add(new Employee(rs.getInt("emp_no"),
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

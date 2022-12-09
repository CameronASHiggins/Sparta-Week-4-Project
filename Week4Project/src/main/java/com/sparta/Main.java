package com.sparta;

import com.sparta.dao.interfaces.DAO;
import com.sparta.dao.mysql.EmployeeDAO;
import com.sparta.entities.Employee;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DAO< Employee> employeeDAO = EmployeeDAO.getInstance();

        displayAllEmployees();

    }

    private static void displayAllEmployees() throws SQLException {
        List<Employee> list = EmployeeDAO.getInstance().findAll();
        for (Employee element : list) {
            System.out.println(element);
        }
    }
}
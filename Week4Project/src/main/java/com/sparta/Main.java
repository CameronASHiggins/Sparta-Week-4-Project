package com.sparta;


import com.sparta.model.dao.interfaces.DAO;

import com.sparta.model.dao.mysql.EmployeeDAO;
import com.sparta.model.entities.Employee;
import com.sparta.utilities.EmployeeToJSONFile;
import com.sparta.utilities.EmployeeToXMLFile;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        DAO<Employee> employeeDAO = EmployeeDAO.getInstance();

        findEmployeeById(employeeDAO, 100001);

//        displayAllEmployees();

//        updateEmployeeMain(employeeDAO,499998,"2000-07-26","Cameron","Higgins","M","2022-11-14");

//        deleteEmployeeMain(employeeDAO,499999);

        List<Employee> retrievedEmployeeslist = new ArrayList<>();

        retrievedEmployeeslist = EmployeeDAO.getEmployeeByStartAndEnd("Development", "1985-01-01", "1990-12-10");

        EmployeeToJSONFile employeeToJSONFile = new EmployeeToJSONFile();
        EmployeeToXMLFile employeeToXMLFile = new EmployeeToXMLFile();

        employeeToJSONFile.retrievedEmployeesToFile((ArrayList<Employee>) retrievedEmployeeslist);
        employeeToXMLFile.retrievedEmployeesToFile((ArrayList<Employee>) retrievedEmployeeslist);

        employeeDAO.close();// In the final user interface we will have a while-loop that when the user is finished and the loop stops this is called and closes the connection

    }

    private static void createEmployeeMain(DAO<Employee> EmployeeDAO, String birthDate, String firstName, String lastName, String gender, String hireDate) throws SQLException {
        Employee insertEmployee = new Employee();
        insertEmployee.setBirthDate(birthDate);
        insertEmployee.setFirstName(firstName);
        insertEmployee.setLastName(lastName);
        insertEmployee.setGender(gender);
        insertEmployee.setHireDate(hireDate);
        EmployeeDAO.insert(insertEmployee);
    }

    private static void updateEmployeeMain(DAO<Employee> EmployeeDAO, int empNo, String birthDate, String firstName, String lastName, String gender, String hireDate) throws SQLException {
        Employee updateEmployee = new Employee();
        updateEmployee.setEmpNo(empNo);
        updateEmployee.setBirthDate(birthDate);
        updateEmployee.setFirstName(firstName);
        updateEmployee.setLastName(lastName);
        updateEmployee.setGender(gender);
        updateEmployee.setHireDate(hireDate);
        EmployeeDAO.update(updateEmployee);
    }

    private static void findEmployeeById(DAO<Employee> employeeDAO, int id) throws SQLException {
        Employee findEmployee = employeeDAO.findByID(id);
        System.out.println(findEmployee);
    }

    private static void deleteEmployeeMain(DAO<Employee> employeeDAO, int id) throws SQLException {
        employeeDAO.delete(id);
    }

    private static void displayAllEmployees() throws SQLException {
        List<Employee> list = EmployeeDAO.getInstance().findAll();
        for (Employee element : list) {
            System.out.println(element);
        }
    }


}
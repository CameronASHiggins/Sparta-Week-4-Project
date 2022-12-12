package com.sparta;


import com.sparta.model.dao.interfaces.DAO;

import com.sparta.model.dao.mysql.EmployeeDAO;
import com.sparta.model.entities.Employee;
import com.sparta.utilities.CSVFileHandler;
import com.sparta.utilities.JSONFormat;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        DAO<Employee> employeeDAO = EmployeeDAO.getInstance();

<<<<<<< HEAD
//        createEmployeeMain(employeeDAO,"2000-02-26","Robert","Ciuches","M","2012-11-14");

//        findEmployeeById(employeeDAO, 100001);
=======
        findEmployeeById(employeeDAO, 100001);
>>>>>>> 1f8a5349fa823d7f74bad7ba69da57c53f004554

//        displayAllEmployees();

//        updateEmployeeMain(employeeDAO,499998,"2000-07-26","Cameron","Higgins","M","2022-11-14");

//        deleteEmployeeMain(employeeDAO,499999);

        Set<String> distinctEmployees = CSVFileHandler.getDistinct(CSVFileHandler.readCSV("src/main/resources/employees01.csv"));
                for (String employee: distinctEmployees.stream().toList()) {
                    String[] employeeData = employee.split(",");
                    System.out.println(employeeData[4]);
//            employeeDAO.insert(new Employee( Integer.parseInt(employeeData[0]),employeeData[1],employeeData[2],employeeData[3],employeeData[4],employeeData[5],"Marketing"));
        }

//        List<String> duplicates = CSVFileHandler.getDuplicates(CSVFileHandler.readCSV("src/main/resources/employees01.csv"));
//        System.out.println(duplicates);

        employeeDAO.close();// In the final user interface we will have a while-loop that when the user is finished and the loop stops this is called and closes the connection
<<<<<<< HEAD
=======


>>>>>>> 1f8a5349fa823d7f74bad7ba69da57c53f004554
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

    private static void updateEmployeeMain(DAO<Employee> EmployeeDAO,int empNo, String birthDate, String firstName, String lastName, String gender, String hireDate) throws SQLException {
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
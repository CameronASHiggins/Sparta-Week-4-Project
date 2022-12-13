package com.sparta;


import com.sparta.model.dao.interfaces.DAO;

import com.sparta.model.dao.mysql.EmployeeDAO;
import com.sparta.model.entities.Employee;
import com.sparta.model.entities.FileFactory;
import com.sparta.utilities.CSVFileHandler;
import com.sparta.utilities.FileType;
import com.sparta.utilities.JSONFormat;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        DAO<Employee> employeeDAO = EmployeeDAO.getInstance();

//        createEmployeeMain(employeeDAO,"2000-02-26","Robert","Ciuches","M","2012-11-14");

//        findEmployeeById(employeeDAO, 100001);
        findEmployeeById(employeeDAO, 100001);

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

    // Phase 2 --------------------------------------------------
    public static void selectAndStoreEmployeesToFile() throws SQLException {

        // Step 1 = User enters Department, Start date, End date
        // result = query the table and get a list or array of employee objects

        // Step 2 = User enter file name and extension ex "devops2019-2022.json"
        // result = appropriate file gets created with the info, using fileFactory
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String Department = null;
        String startDate = null;
        String endDate = null;
        String outFile = null;

        //--------------------- Get User Input -----------------------------

        System.out.println("Please Enter a Department:");
        Department = myObj.nextLine();  // Read user input

        System.out.println("Please Enter a Start Date:");
        startDate = myObj.nextLine();  // Read user input

        System.out.println("Please Enter a Department:");
        endDate = myObj.nextLine();  // Read user input

        System.out.println("Please Enter the filename you wish to save in:");
        outFile = myObj.nextLine();  // Read user input

        List<Employee> es = EmployeeDAO.getInstance().getEmployeeByStartAndEnd(Department, startDate, endDate);

        FileFactory ff = new FileFactory();

        FileType ft = ff.storeToSpecifiedFile( outFile );

        //List<Employee> es = new ArrayList<>();
        //es.add( new Employee(1,"2","3","4","5","6","7"));
        //es.add( new Employee(10,"20","30","40","50","60","70") );

        ft.writeToFile( es, outFile );


    }



}
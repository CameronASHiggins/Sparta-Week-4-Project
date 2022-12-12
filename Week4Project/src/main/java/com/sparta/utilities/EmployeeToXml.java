package com.sparta.utilities;

import com.sparta.model.dao.mysql.EmployeeDAO;
import com.sparta.model.entities.Employee;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeToXml {

    private static final String saveDirectory = "Week4Project/src/main/resources/";
    // TODO: confirm file in right location
    public static void convertToXml(String dept, String start, String end){

        Employee[] employees = mapToArray( dept,  start,  end);
        String fileName = generateFileName( dept,  start,  end);

        XMLFormat xmlFormat = new XMLFormat();
        xmlFormat.writeToFile(employees, saveDirectory+fileName);

    }

    private static String generateFileName(String dept, String start, String end){
//        format is Output-department-From-startDate-To-endDate-random.xml
//        The directory is saveDirectory variable

        String fileName = new String("Output")
                .concat("-")
                .concat(dept)
                .concat("-From-")
                .concat(start)
                .concat("-To-")
                .concat(end)
                .concat("-")
                .concat(String.valueOf(new Random().nextInt()))
                .concat(".xml");
        return fileName;

    }

//    Map resulting employee to array
    private static Employee[] mapToArray(String dept, String start, String end){
        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();

        try {
            //        get employee by department and time period
            List<Employee> employees = employeeDAO.getEmployeeByStartAndEnd(dept, start, end);

//convert to array for XML function
            Employee[] employeesArray = new Employee[employees.size()];

            for (int i = 0; i < employees.size(); i++) {
                employeesArray[i] = employees.get(i);
            }

            return employeesArray;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

package com.sparta.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysql.cj.callback.MysqlCallbackHandler;
import com.sparta.formatDrivers.XMLDriver;
import com.sparta.model.dao.mysql.EmployeeDAO;
import com.sparta.model.entities.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeToXmlTest {



    @Test
    @DisplayName("Given a set of conditions, assert an Employee array can be built and return the same int as results of getEmployeeByStartAndEnd")
    void mapArrayEmployees(){
        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
        String dept = "Development";
        String start = "1980-01-01";
        String end = "1990-01-01";

        try {
            List<Employee> employees = employeeDAO.getEmployeeByStartAndEnd(dept, start, end);


            Employee[] employeesArray = new Employee[employees.size()];

            for (int i = 0; i < employees.size(); i++) {
                employeesArray[i] = employees.get(i);
            }

            assertNotNull(employeesArray);
            assertEquals(employees.size(), employeesArray.length);
            System.out.println(employeesArray);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    @DisplayName("Given a 10 year period, create a xml and assert it exists")
    void EmployeeToXml(){
        String dept = "Development";
        String start = "1980-01-01";
        String end = "1990-01-01";

        EmployeeToXml.convertToXml(dept, start, end);
    }


}
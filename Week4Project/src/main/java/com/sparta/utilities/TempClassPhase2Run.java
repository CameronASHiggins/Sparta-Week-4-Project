package com.sparta.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.model.dao.mysql.EmployeeDAO;
import com.sparta.model.entities.FileFactory;
import com.sparta.model.entities.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TempClassPhase2Run {

    public static void main(String[] args) throws SQLException, JsonProcessingException {

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
        Employee e = new Employee(4, "1998-01-20","Joe","Grey","M","2020-01-05","Quality Management");
        System.out.println(e);
        JSONFormat x = new JSONFormat();
        System.out.println( x.ObjToJson(e) );

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

package com.sparta.utilities;

import com.sparta.model.dao.interfaces.EmployeeObjectToFile;
import com.sparta.model.entities.Employee;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeToJSONFile implements EmployeeObjectToFile {

    @Override
    public void retrievedEmployeesToFile(ArrayList<Employee> retrievedEmployeeslist){

        try (FileWriter file = new FileWriter("retrievedEmployees.json")) {

            for (Employee employee : retrievedEmployeeslist) {

                JSONObject jsonObject = new JSONObject();

                jsonObject.put("emp_no", employee.getEmpNo());
                jsonObject.put("birth_date", employee.getBirthDate());
                jsonObject.put("first_name", employee.getFirstName());
                jsonObject.put("last_name", employee.getLastName());
                jsonObject.put("gender", employee.getGender());
                jsonObject.put("hire_date", employee.getHireDate());
                jsonObject.put("dept_name", employee.getDepartment());

                try {
                    file.write(jsonObject.toJSONString());
//                    file.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}

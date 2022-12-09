package com.sparta.model.entities;

import com.sparta.departmentgroup.*;
import com.sparta.*;


    public class EmployeeFactory {
        public Employee createEmployee(String channel, int emp_no, String birth_date, String first_name, String last_name, String gender, String hire_date)
        {
            switch(channel)
            {
                case "Customer Service":
                    return new CustomerService(emp_no, birth_date, first_name, last_name, gender, hire_date);
                case "Human Resources":
                    return new HumanResources(emp_no, birth_date, first_name, last_name, gender, hire_date);
                case "Marketing":
                    return new Marketing(emp_no, birth_date, first_name, last_name, gender, hire_date);
                case "Development":
                    return new Development(emp_no, birth_date, first_name, last_name, gender, hire_date);
                case "Finance":
                    return new Finance(emp_no, birth_date, first_name, last_name, gender, hire_date);
                case "Quality Management":
                    return new QualityManagement(emp_no, birth_date, first_name, last_name, gender, hire_date);
                case "Research":
                    return new Research(emp_no, birth_date, first_name, last_name, gender, hire_date);
                case "Sales":
                    return new Sales(emp_no, birth_date, first_name, last_name, gender, hire_date);
                case "Production":
                    return new Production(emp_no, birth_date, first_name, last_name, gender, hire_date);
                default:
                    throw new IllegalArgumentException("Unknown channel "+channel);
            }
        }
    }

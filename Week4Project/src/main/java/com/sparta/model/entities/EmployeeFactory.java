package com.sparta.model.entities;

import com.sparta.departmentgroup.*;
import com.sparta.*;


    public class EmployeeFactory {
        public Employee createEmployee(String departmentNo, int emp_no, String birth_date, String first_name, String last_name, String gender, String hire_date, String department)
        {
            switch(departmentNo)
            {
                case "d009":
                    return new CustomerService(emp_no, birth_date, first_name, last_name, gender, hire_date, department);
                case "d003":
                    return new HumanResources(emp_no, birth_date, first_name, last_name, gender, hire_date, department);
                case "d001":
                    return new Marketing(emp_no, birth_date, first_name, last_name, gender, hire_date, department);
                case "d005":
                    return new Development(emp_no, birth_date, first_name, last_name, gender, hire_date, department);
                case "d002":
                    return new Finance(emp_no, birth_date, first_name, last_name, gender, hire_date, department);
                case "d006":
                    return new QualityManagement(emp_no, birth_date, first_name, last_name, gender, hire_date, department);
                case "d008":
                    return new Research(emp_no, birth_date, first_name, last_name, gender, hire_date, department);
                case "d007":
                    return new Sales(emp_no, birth_date, first_name, last_name, gender, hire_date, department);
                case "d004":
                    return new Production(emp_no, birth_date, first_name, last_name, gender, hire_date, department);
                default:
                    throw new IllegalArgumentException("Unknown channel "+departmentNo);
            }
        }
    }

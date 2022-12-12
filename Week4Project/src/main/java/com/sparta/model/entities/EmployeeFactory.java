package com.sparta.model.entities;

import com.sparta.departmentgroup.*;
import com.sparta.*;


    public class EmployeeFactory {
        public Employee createEmployee(String channel, int empNo, String birthDate, String firstName, String lastName, String gender, String hireDate, String department)
        {
            switch(channel)
            {
                case "Customer Service":
                    return new CustomerService(empNo, birthDate, firstName, lastName, gender, hireDate, department);
                case "Human Resources":
                    return new HumanResources(empNo, birthDate, firstName, lastName, gender, hireDate, department);
                case "Marketing":
                    return new Marketing(empNo, birthDate, firstName, lastName, gender, hireDate, department);
                case "Development":
                    return new Development(empNo, birthDate, firstName, lastName, gender, hireDate, department);
                case "Finance":
                    return new Finance(empNo, birthDate, firstName, lastName, gender, hireDate, department);
                case "Quality Management":
                    return new QualityManagement(empNo, birthDate, firstName, lastName, gender, hireDate, department);
                case "Research":
                    return new Research(empNo, birthDate, firstName, lastName, gender, hireDate, department);
                case "Sales":
                    return new Sales(empNo, birthDate, firstName, lastName, gender, hireDate, department);
                case "Production":
                    return new Production(empNo, birthDate, firstName, lastName, gender, hireDate, department);
                default:
                    throw new IllegalArgumentException("Unknown channel "+channel);
            }
        }
    }

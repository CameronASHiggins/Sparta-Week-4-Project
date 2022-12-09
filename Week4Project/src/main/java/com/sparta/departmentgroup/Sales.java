package com.sparta.departmentgroup;


import com.sparta.model.dao.interfaces.Department;
import com.sparta.model.entities.Employee;

import java.time.LocalDate;

public class Sales extends Employee implements Department {


    public Sales(int emp_no, String birth_date, String first_name, String last_name, String gender, String hire_date) {
        super(emp_no, birth_date, first_name, last_name, gender, hire_date);
    }

    @Override
    public void job() {
        System.out.println("I am part of Sales");
    }
}

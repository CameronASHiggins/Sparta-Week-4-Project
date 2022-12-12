package com.sparta.departmentgroup;

import com.sparta.model.entities.Employee;

public class Sales extends Employee implements DepartmentInterface {

    public Sales(int emp_no, String birth_date, String first_name, String last_name, String gender, String hireDate, String department) {
        super(emp_no, birth_date, first_name, last_name, gender, hireDate, department);
    }

    @Override
    public void job() {
        System.out.println("I am part of Sales");
    }
}

package com.sparta.departmentgroup;


import com.sparta.model.entities.Employee;

public class Finance extends Employee implements DepartmentInterface {

    public Finance(int empNo, String birthDate, String firstName, String lastName, String gender, String hireDate, String department) {
        super(empNo, birthDate, firstName, lastName, gender, hireDate, department);
    }

    @Override
    public void job() {
        System.out.println("I am part of Finance");
    }
}

package com.sparta.model.dao.interfaces;

import com.sparta.model.entities.Employee;

import java.util.ArrayList;

@FunctionalInterface
public interface EmployeeObjectToFile {

    public void retrievedEmployeesToFile(ArrayList<Employee> retrievedEmployeeslist);

}

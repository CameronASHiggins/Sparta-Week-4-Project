package com.sparta.utilities;

import com.sparta.model.entities.Employee;

import java.util.List;


public interface FileType {
    public void writeToFile(List<Employee> employees , String outFile);
}

package com.sparta.entities;

public class Employee {

    private String employeeNumber;
    private String birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private String hireDate;

    public Employee(){}

    public Employee(String employeeNumber, String birthDate, String firstName, String lastName, String gender, String hireDate) {
        this.employeeNumber = employeeNumber;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hireDate = hireDate;
    }

    public String getLastName() {
        return lastName.toLowerCase();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", birthDate=" + birthDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}

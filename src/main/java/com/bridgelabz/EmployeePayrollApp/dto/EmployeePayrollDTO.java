package com.bridgelabz.EmployeePayrollApp.dto;

public class EmployeePayrollDTO {
    public String name;
    public String department;
    public String gender;
    public long salary;

    public EmployeePayrollDTO(String name, String department, String gender, long salary){
        this.name=name;
        this.department=department;
        this.gender=gender;
        this.salary=salary;
    }
    public String toString(){
        return "name: "+name+", department: "+department+", gender: "+gender+", salary: "+salary;
    }
}

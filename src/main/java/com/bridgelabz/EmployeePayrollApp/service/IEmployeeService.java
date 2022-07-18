package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;

import java.util.List;

public interface IEmployeeService {
//    public String helloMessage();

    Employee addEmployee(EmployeePayrollDTO empPayrollDTO);
    Employee getEmployeeById(int id);
    List<Employee> getEmployees();
    Employee editEmployee(int id, EmployeePayrollDTO empPayrollDTO);
    void deleteEmployee(int id);
}

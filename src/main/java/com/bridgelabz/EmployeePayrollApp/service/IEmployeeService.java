package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;

import java.util.List;

public interface IEmployeeService {
//    public String helloMessage();

    Employee addEmployee(EmployeePayrollDTO empPayrollDTO);
    Employee getEmployeeById(Long id);
    List<Employee> getEmployees();
    Employee editEmployee(EmployeePayrollDTO empPayrollDTO);
    void deleteEmployee(Long id);
}

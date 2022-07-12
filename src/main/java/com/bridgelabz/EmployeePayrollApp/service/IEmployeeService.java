package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public String helloMessage();

    Employee addEmployee(Employee employee);
    Employee getGreetingById(Long id);
    List<Employee> getEmployees();
    Employee editEmployee(Employee employee, Long emp_id);
    void deleteEmployee(Long id);
}

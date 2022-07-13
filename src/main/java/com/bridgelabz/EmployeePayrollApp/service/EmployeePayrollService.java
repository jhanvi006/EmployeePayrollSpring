package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeeService {
    @Autowired
    private EmployeeRepository repository;
//    @Override
//    public String helloMessage() {
//        return "Welcome to Employee Payroll Application.";
//    }
    @Override
    public Employee addEmployee(EmployeePayrollDTO empPayrollDTO) {
        Employee employee = new Employee(1, empPayrollDTO);
        return employee;
    }
    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = new Employee(1, new EmployeePayrollDTO("Jhanvi", "engineering", "female", 30000));
        return employee;
    }
    @Override
    public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, new EmployeePayrollDTO("Jhanvi", "engineering", "female", 30000)));
        return employeeList;
    }
    @Override
    public Employee editEmployee(EmployeePayrollDTO empPayrollDTO) {
        Employee employee = new Employee(1, empPayrollDTO);
        return employee;
    }
    @Override
    public void deleteEmployee(Long id) {
//        repository.deleteById(id);
//        return "Data deleted!";
    }
}

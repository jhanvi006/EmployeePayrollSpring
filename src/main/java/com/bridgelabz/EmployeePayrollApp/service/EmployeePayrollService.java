package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.exceptions.EmployeePayrollException;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeeService {
    private List<Employee> employeeList = new ArrayList<>();
    @Autowired
    private EmployeeRepository repository;
//    @Override
//    public String helloMessage() {
//        return "Welcome to Employee Payroll Application.";
//    }
    @Override
    public Employee addEmployee(EmployeePayrollDTO empPayrollDTO) {
        Employee employee = new Employee(empPayrollDTO);
        log.debug("emp data: "+ employee);
        return repository.save(employee);
    }
    @Override
    public Employee getEmployeeById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeePayrollException("Employee with id "+id+" not found!"));
    }
    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }
    @Override
    public Employee editEmployee(int id, EmployeePayrollDTO empPayrollDTO) {
        Employee employee = this.getEmployeeById(id);
        employee.updateData(empPayrollDTO);
        return repository.save(employee);
    }
    @Override
    public void deleteEmployee(int id) {
        Employee employee = this.getEmployeeById(id);
        repository.delete(employee);
    }
}

package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.exceptions.EmployeePayrollException;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
        Employee employee = new Employee(employeeList.size()+1, empPayrollDTO);
        employeeList.add(employee);
        return employee;
    }
    @Override
    public Employee getEmployeeById(int id) {
        return employeeList.stream()
                .filter(empData -> empData.getEmployee_id() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee not found!"));
    }
    @Override
    public List<Employee> getEmployees() {
        return employeeList;
    }
    @Override
    public Employee editEmployee(int id, EmployeePayrollDTO empPayrollDTO) {
        Employee employee = this.getEmployeeById(id);
        employee.setName(empPayrollDTO.name);
        employee.setDepartment(empPayrollDTO.department);
        employee.setGender(empPayrollDTO.gender);
        employee.setSalary(empPayrollDTO.salary);
        employeeList.set(id-1, employee);
        return employee;
    }
    @Override
    public void deleteEmployee(int id) {
        employeeList.remove(id-1);
    }
}

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
        Employee searchEmployee = employeeList.stream()
                .filter(empData -> empData.getEmployee_id() == id)
                .findFirst().orElse(null);
        if(searchEmployee != null) {
            searchEmployee.setName(empPayrollDTO.name);
            searchEmployee.setDepartment(empPayrollDTO.department);
            searchEmployee.setGender(empPayrollDTO.gender);
            searchEmployee.setSalary(empPayrollDTO.salary);
            employeeList.set(id - 1, searchEmployee);
            return searchEmployee;
        }
        else
            throw new EmployeePayrollException("Employee with id "+id+" not found!");
    }
    @Override
    public String deleteEmployee(int id) {
        Employee searchEmployee = employeeList.stream()
                .filter(empData -> empData.getEmployee_id() == id)
                .findFirst().orElse(null);
        if(searchEmployee != null) {
            employeeList.remove(searchEmployee);
            return "Employee with id "+id+" deleted successfully.";
        }
        else
            throw new EmployeePayrollException("Employee with id "+id+" not found!");
    }
}

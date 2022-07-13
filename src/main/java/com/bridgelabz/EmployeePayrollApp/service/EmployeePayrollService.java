package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeeService {
    @Autowired
    private EmployeeRepository repository;
    @Override
    public String helloMessage() {
        return "Welcome to Employee Payroll Application.";
    }
    @Override
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }
    @Override
    public Employee getGreetingById(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }
    @Override
    public Employee editEmployee(Employee employee, Long emp_id) {
        Employee existingEmp = repository.findById(emp_id).orElse(null);
        if (existingEmp != null) {
            existingEmp.setName(employee.getName());
            existingEmp.setDepartment(employee.getDepartment());
            existingEmp.setGender(employee.getGender());
            existingEmp.setSalary(employee.getSalary());
            return repository.save(existingEmp);
        }else return null;
    }
    @Override
    public String deleteEmployee(Long id) {
        repository.deleteById(id);
        return "Data deleted!";
    }
}

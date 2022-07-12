package com.bridgelabz.EmployeePayrollApp.controller;

import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping(value = {"", "/", "/home"})
    public String sayHello(){
        return employeePayrollService.helloMessage();
    }
    @PostMapping("/addEmployee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeePayrollService.addEmployee(employee);
    }
    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeePayrollService.getGreetingById(id);
    }
    @GetMapping("/allEmployees")
    public List<Employee> displayAllEmployees() {
        return employeePayrollService.getEmployees();
    }
    @PutMapping("/editEmployee/{emp_id}")
    public Employee editEmployee(@RequestBody Employee employee, @PathVariable Long emp_id){
        return employeePayrollService.editEmployee(employee, emp_id);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeePayrollService.deleteEmployee(id);
    }
}

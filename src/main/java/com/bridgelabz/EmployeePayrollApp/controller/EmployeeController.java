package com.bridgelabz.EmployeePayrollApp.controller;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.dto.ResponseDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping(value = {"", "/", "/home"})
    public ResponseEntity<ResponseDTO> getEmployeeData(){
        Employee employee = null;
        employee = new Employee(1, new EmployeePayrollDTO("Jhanvi", "engineering", "female", 30000));
        ResponseDTO responseDTO = new ResponseDTO("Get call successful", employee);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/addEmployee")
    public ResponseEntity<ResponseDTO> createEmployee(@RequestBody EmployeePayrollDTO empPayrollDTO){
        Employee employee = new Employee(1, empPayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll data successfully", employee);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<ResponseDTO> getEmployeeById(@PathVariable Long id){
        Employee employee = null;
        employee = new Employee(1, new EmployeePayrollDTO("Jhanvi", "engineering", "female", 30000));
        ResponseDTO responseDTO = new ResponseDTO("Get call for id successful", employee);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
//    @GetMapping("/allEmployees")
//    public List<Employee> displayAllEmployees() {
//        return employeePayrollService.getEmployees();
//    }
    @PutMapping("/editEmployee")
    public ResponseEntity<ResponseDTO> editEmployee(@RequestBody EmployeePayrollDTO empPayrollDTO){
        Employee employee = new Employee(1, empPayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll data successfully", employee);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable Long id){
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted id: "+id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

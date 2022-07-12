package com.bridgelabz.EmployeePayrollApp.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService implements IEmployeeService {
    @Override
    public String helloMessage() {
        return "Welcome to Employee Payroll Application.";
    }
}

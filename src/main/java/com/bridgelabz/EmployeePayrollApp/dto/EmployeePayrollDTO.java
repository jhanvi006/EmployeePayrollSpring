package com.bridgelabz.EmployeePayrollApp.dto;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
public class EmployeePayrollDTO {
//    @NotEmpty(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name invalid")
    public String name;
    @NotEmpty(message = "Department cannot be empty.")
    public String department;
    @NotEmpty(message = "Gender cannot be empty.")
    public String gender;
    @Min(value = 500, message = "Salary should be minimum 500")
    public long salary;
}

package com.bridgelabz.EmployeePayrollApp.dto;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@ToString
public class EmployeePayrollDTO {
//    @NotEmpty(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name invalid")
    public String name;
    public List<String> department;
    @NotEmpty(message = "Gender cannot be empty.")
    public String gender;
    @Min(value = 500, message = "Salary should be minimum 500")
    public long salary;
    public String note;
    public LocalDate startDate;
    public String profilePic;
}

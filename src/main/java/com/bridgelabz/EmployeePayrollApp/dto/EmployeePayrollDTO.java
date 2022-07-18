package com.bridgelabz.EmployeePayrollApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@ToString
public class EmployeePayrollDTO {
//    @NotEmpty(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}(\\s[a-zA-Z])*$", message = "Employee name invalid")
    public String name;
    @NotEmpty(message = "Department should not be empty")
    public List<String> department;
    @Pattern(regexp = "male|female",message = "Gender needs to be male or female.")
    public String gender;
    @Min(value = 500, message = "Salary should be minimum 500")
    public long salary;
    @NotBlank(message = "Note cannot be empty.")
    public String note;
    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "Start Date should not be empty")
    @PastOrPresent(message = "Start Date should be past or today's date.")
    public LocalDate startDate;
    @NotBlank(message = "Profile pic cannot be empty.")
    public String profilePic;
}

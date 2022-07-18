package com.bridgelabz.EmployeePayrollApp.model;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    private int employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    private List<String> department;

    public Employee(EmployeePayrollDTO employeePayrollDTO){
        this.updateData(employeePayrollDTO);
    }
    public void updateData(EmployeePayrollDTO employeePayrollDTO){
        this.name=employeePayrollDTO.name;
        this.salary= employeePayrollDTO.salary;
        this.gender=employeePayrollDTO.gender;
        this.note=employeePayrollDTO.note;
        this.startDate=employeePayrollDTO.startDate;
        this.profilePic=employeePayrollDTO.profilePic;
        this.department=employeePayrollDTO.department;
    }
}



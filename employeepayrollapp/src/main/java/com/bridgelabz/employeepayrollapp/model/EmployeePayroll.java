package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "employee_payroll")
public class EmployeePayroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> department;
    private String name;


    public EmployeePayroll() {}

    public EmployeePayroll(int id,EmployeePayrollDTO employeePayroll) {
        this.id=id;
        this.name = employeePayroll.name;
        this.salary = employeePayroll.salary;
        this.gender=employeePayroll.gender;
        this.startDate=employeePayroll.startDate;
        this.note=employeePayroll.note;
        this.profilePic=employeePayroll.profilePic;
        this.department=employeePayroll.department;
    }
}
package com.bridgelabz.employeepayrollapp.model;

import lombok.Data;
import jakarta.persistence.*;


@Entity
@Data
@Table(name = "employee_payroll")

public class EmployeePayroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private long salary;

    public EmployeePayroll() {}

    public EmployeePayroll(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }


}
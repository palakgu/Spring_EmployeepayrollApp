package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.Data;

@Data
public class EmployeePayrollDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Name must start with a capital letter and be at least 3 characters long")
    private String name;

    @Min(value = 1000, message = "Salary must be at least 1000")
    @Max(value = 1000000, message = "Salary cannot exceed 1,000,000")
    private int salary;
    public EmployeePayrollDTO(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO{name='" + name + "', salary=" + salary + "}";
    }
}

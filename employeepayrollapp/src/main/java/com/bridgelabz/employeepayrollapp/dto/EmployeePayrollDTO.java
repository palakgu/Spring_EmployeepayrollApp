package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
@Data
@ToString
public class EmployeePayrollDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Name must start with a capital letter and be at least 3 characters long")
    public String name;

    @Min(value = 1000, message = "Salary must be at least 1000")
    @Max(value = 1000000, message = "Salary cannot exceed 1,000,000")
    public int salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> department;

}

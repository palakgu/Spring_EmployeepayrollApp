package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
@Data
@ToString
public class  EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee name Invalid")
    public String name;

    @Min(value = 500, message = "Min Wage should be more than 500")
    public int salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "startDate should Not be Empty")
    @PastOrPresent(message = "startDate should be past or today's date")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be Empty")
    public String note;

    @NotBlank(message = "profilePic cannot be Empty")
    public String profilePic;

    @NotNull(message = "department should Not be Empty")
    public List<String> department;
}

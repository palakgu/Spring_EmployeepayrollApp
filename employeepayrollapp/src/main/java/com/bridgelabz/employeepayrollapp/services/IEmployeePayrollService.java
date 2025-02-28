package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayroll;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayroll> getAllEmployees();
    EmployeePayroll getEmployeeById(int id);
    EmployeePayroll createEmployee(EmployeePayrollDTO employeeDTO);
    EmployeePayroll updateEmployee(int id, EmployeePayrollDTO employeeDTO);
    boolean deleteEmployee(int id);
}
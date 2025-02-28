package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.employeepayrollapp.model.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.services.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService service;

    @GetMapping("/")
    public List<EmployeePayroll> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public EmployeePayroll getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeePayroll> createEmployee(@Valid @RequestBody EmployeePayrollDTO employeeDTO) {
        EmployeePayroll employee = service.createEmployee(employeeDTO);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeePayroll> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeePayrollDTO employeeDTO) {
        EmployeePayroll updatedEmployee = service.updateEmployee(id, employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id) ? "Deleted Successfully" : "Employee Not Found";
    }
}
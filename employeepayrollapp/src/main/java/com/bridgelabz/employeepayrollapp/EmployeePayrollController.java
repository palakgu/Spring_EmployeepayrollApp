package com.bridgelabz.employeepayrollapp;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping("/")
    public String getAllEmployees() {
        return "Fetching all employees";
    }

    @GetMapping("/get/{id}")
    public String getEmployeeById(@PathVariable int id) {
        return "Fetching employee with ID: " + id;
    }

    @PostMapping("/create")
    public String addEmployee(@RequestBody String employee) {
        return "Adding new employee: " + employee;
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody String employee) {
        return "Updating employee with ID " + id + " to: " + employee;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return "Deleting employee with ID: " + id;
    }
}
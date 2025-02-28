package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository repository;


    public List<EmployeePayroll> getAllEmployees() {
        log.info("Fetching all employees");
        return repository.findAll();
    }

    public EmployeePayroll getEmployeeById(int id) {
        log.info("Fetching employee with ID: {}", id);
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
    }

    public EmployeePayroll createEmployee(@Valid EmployeePayrollDTO employeeDTO) {
        EmployeePayroll employee = new EmployeePayroll();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());

        return repository.save(employee);
    }

    public EmployeePayroll updateEmployee(int id, @Valid EmployeePayrollDTO newEmployee) {
        Optional<EmployeePayroll> existingEmployee = repository.findById(id);
        if (existingEmployee.isPresent()) {
            log.info("Updating employee with ID: {}", id);
            EmployeePayroll employee = existingEmployee.get();
            employee.setName(newEmployee.getName());
            employee.setSalary(newEmployee.getSalary());
            return repository.save(employee);
        }
        log.warn("Employee with ID {} not found for update", id);
        return null;
    }

    public boolean deleteEmployee(int id) {

        if (!repository.existsById(id)) {
            log.warn("Employee with ID {} not found for deletion", id);
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }

        log.info("Deleting employee with ID: {}", id);
        repository.deleteById(id);

        return true;
    }
}
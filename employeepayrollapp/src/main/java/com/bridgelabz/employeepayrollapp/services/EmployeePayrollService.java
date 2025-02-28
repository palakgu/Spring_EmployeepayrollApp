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

@Slf4j
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository repository;

    public List<EmployeePayroll> getAllEmployees() {
        log.info("Fetching all employees");
        return repository.findAll();
    }

    public EmployeePayroll getEmployeeById(int id) {
        log.info("Fetching employee with ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
    }

    public EmployeePayroll createEmployee(@Valid EmployeePayrollDTO employeeDTO) {
        log.info("Creating employee: {}", employeeDTO.name);
        EmployeePayroll employee = new EmployeePayroll(employeeDTO);
        return repository.save(employee);
    }

    public EmployeePayroll updateEmployee(int id, @Valid EmployeePayrollDTO newEmployeeDTO) {
        EmployeePayroll existingEmployee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));

        log.info("Updating employee with ID: {}", id);
        existingEmployee.updateEmployeePayrollData(newEmployeeDTO);
        return repository.save(existingEmployee);
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
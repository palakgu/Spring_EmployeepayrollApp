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
        return repository.findAll();
    }


    public EmployeePayroll getEmployeeById(int empId) {
        return repository.findById(empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + empId + " does not exist!"));
    }


    public EmployeePayroll createEmployee(@Valid EmployeePayrollDTO empPayrollDTO) {
        EmployeePayroll empData = new EmployeePayroll(empPayrollDTO);
        return repository.save(empData);
    }


    public EmployeePayroll updateEmployee(int id, @Valid EmployeePayrollDTO newEmployeeDTO) {
        EmployeePayroll existingEmployee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));

        existingEmployee.updateEmployeePayrollData(newEmployeeDTO);
        return repository.save(existingEmployee);
    }


    public boolean deleteEmployee(int id) {
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        repository.deleteById(id);
        return true;
    }
}
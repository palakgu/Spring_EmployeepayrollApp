package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.model.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository repository;

    public List<EmployeePayroll> getAllEmployees() {
        return repository.findAll();
    }

    public EmployeePayroll getEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    public EmployeePayroll createEmployee(EmployeePayroll employee) {
        return repository.save(employee);
    }

    public EmployeePayroll updateEmployee(int id, EmployeePayroll newEmployee) {
        Optional<EmployeePayroll> existingEmployee = repository.findById(id);
        if (existingEmployee.isPresent()) {
            EmployeePayroll employee = existingEmployee.get();
            employee.setName(newEmployee.getName());
            employee.setSalary(newEmployee.getSalary());
            return repository.save(employee);
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
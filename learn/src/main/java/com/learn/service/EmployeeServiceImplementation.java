package com.learn.service;

import com.learn.entity.Employee;
import com.learn.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllEmployees();
    }

    @Override
    public Optional<Employee> findEmployeeById(int employeeId) {
        return Optional.ofNullable(employeeRepository.findEmployeeById(employeeId));
    }

    @Override
    @Transactional
    public Employee SaveEmployee(Employee employee) {
        return employeeRepository.SaveEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteEmployee(employeeId);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }
}

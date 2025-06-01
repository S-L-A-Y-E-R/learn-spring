package com.learn.service;

import com.learn.entity.Employee;
import com.learn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Employee findEmployeeById(int employeeId) {
        return employeeRepository.findEmployeeById(employeeId);
    }

    @Override
    public void SaveEmployee(Employee employee) {
        employeeRepository.SaveEmployee(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteEmployee(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }
}

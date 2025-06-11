package com.learn.service;

import com.learn.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Optional<Employee> findEmployeeById(int employeeId);

    Employee SaveEmployee(Employee employee);

    void deleteEmployee(int employeeId);

    Employee updateEmployee(Employee employee);
}

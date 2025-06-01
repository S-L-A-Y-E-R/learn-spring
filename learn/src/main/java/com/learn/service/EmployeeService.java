package com.learn.service;

import com.learn.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findEmployeeById(int employeeId);

    void SaveEmployee(Employee employee);

    void deleteEmployee(int employeeId);

    void updateEmployee(Employee employee);
}

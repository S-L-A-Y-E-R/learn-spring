package com.learn.dao;

import com.learn.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAllEmployees();

    Employee findEmployeeById(int employeeId);

    Employee SaveEmployee(Employee employee);

    void deleteEmployee(int employeeId);

    Employee updateEmployee(Employee employee);
}

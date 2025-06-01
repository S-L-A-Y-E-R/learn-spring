package com.learn.dao;

import com.learn.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAllEmployees();

    Employee findEmployeeById(int employeeId);

    void SaveEmployee(Employee employee);

    void deleteEmployee(int employeeId);

    void updateEmployee(Employee employee);
}

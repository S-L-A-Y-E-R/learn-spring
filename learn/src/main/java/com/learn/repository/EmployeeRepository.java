package com.learn.repository;

import com.learn.dao.EmployeeDAO;
import com.learn.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository implements EmployeeDAO {
    EntityManager entityManager;

    @Autowired
    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        return entityManager.find(Employee.class,employeeId);
    }

    @Override
    public Employee SaveEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Employee employee = entityManager.find(Employee.class,employeeId);
        entityManager.remove(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return entityManager.merge(employee);
    }
}

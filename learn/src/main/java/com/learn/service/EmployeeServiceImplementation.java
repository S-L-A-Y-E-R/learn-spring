//package com.learn.service;
//
//import com.learn.entity.Employee;
//import com.learn.repository.EmployeeJpaRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmployeeServiceImplementation implements EmployeeService{
//    EmployeeJpaRepository employeeJpaRepository;
//
//    @Autowired
//    public EmployeeServiceImplementation(EmployeeJpaRepository employeeJpaRepository) {
//        this.employeeJpaRepository = employeeJpaRepository;
//    }
//
//
//    @Override
//    public List<Employee> findAll() {
//        return employeeJpaRepository.findAll();
//    }
//
//    @Override
//    public Optional<Employee> findEmployeeById(int employeeId) {
//        return employeeJpaRepository.findById(employeeId);
//    }
//
//    @Override
//    @Transactional
//    public Employee SaveEmployee(Employee employee) {
//        return employeeJpaRepository.save(employee);
//    }
//
//    @Override
//    @Transactional
//    public void deleteEmployee(int employeeId) {
//        employeeJpaRepository.deleteById(employeeId);
//    }
//
//    @Override
//    @Transactional
//    public Employee updateEmployee(Employee employee) {
//        return employeeJpaRepository.save(employee);
//    }
//}

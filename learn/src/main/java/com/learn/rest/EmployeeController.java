package com.learn.rest;

import com.learn.entity.Employee;
import com.learn.repository.EmployeeRepository;
import com.learn.service.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    EmployeeServiceImplementation employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImplementation employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        return employeeService.findEmployeeById(employeeId);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee){
         employeeService.SaveEmployee(employee);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }
}

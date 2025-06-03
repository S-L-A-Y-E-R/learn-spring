//package com.learn.rest;
//
//import com.learn.entity.Employee;
//import com.learn.repository.EmployeeRepository;
//import com.learn.service.EmployeeServiceImplementation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class EmployeeController {
//    EmployeeServiceImplementation employeeService;
//
//    @Autowired
//    public EmployeeController(EmployeeServiceImplementation employeeService) {
//        this.employeeService = employeeService;
//    }
//
//    @GetMapping("/employees")
//    public List<Employee> getAllEmployees(){
//        return employeeService.findAll();
//    }
//
//    @GetMapping("/employees/{employeeId}")
//    public Employee getEmployee(@PathVariable int employeeId){
//        return employeeService.findEmployeeById(employeeId).orElseThrow();
//    }
//
//    @DeleteMapping("/employees/{employeeId}")
//    public void deleteEmployee(@PathVariable int employeeId){
//        employeeService.deleteEmployee(employeeId);
//    }
//
//    @PostMapping("/employees")
//    public Employee addEmployee(@RequestBody Employee employee){
//        employee.setId(0);
//         return employeeService.SaveEmployee(employee);
//    }
//
//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee employee){
//        return employeeService.updateEmployee(employee);
//    }
//}

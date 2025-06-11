package com.learn.rest;

import com.learn.entity.Employee;
import com.learn.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeMvcController {
    private final EmployeeService service;

    public EmployeeMvcController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping ("/list")
    public String listEmployees(Model model){
        List<Employee> employeeList = service.findAll();
        model.addAttribute("employees",employeeList);
        return "employee-form";
    }

    @GetMapping("/add")
    public String addEmployee(Model model){
        model.addAttribute("employee",new Employee());
        return "add-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee){
        System.out.println(employee);
        if(service.findEmployeeById(employee.getId()).isPresent()){
            service.updateEmployee(employee);
        } else {
            service.SaveEmployee(employee);
        }
        return "redirect:/employee/list";
    }

    @GetMapping("/update")
    public String updateEmployee(Model model,@RequestParam("employeeId") int employeeId ){
        Employee employee = service.findEmployeeById(employeeId).orElseThrow();
        model.addAttribute("employee",employee);
        return "/update-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(Model model,@RequestParam("employeeId") int employeeId){
        service.deleteEmployee(employeeId);
        return "redirect:/employee/list";
    }
}

package com.example.psgrooming.controller;

import com.example.psgrooming.model.Employee;
import com.example.psgrooming.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) throws Exception{
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee emp){
        employeeService.createEmployee(emp);
        return "Employee Successfully added !!";
    }

    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable("id") int id, @RequestBody Employee emp) throws Exception{
        return employeeService.updateEmployeeById(id,emp);
    }

    @DeleteMapping("/{id}")
    public String dalateEmployeeById(@PathVariable("id") int id) throws Exception{
        employeeService.deleteEmployeeById(id);
        return "Employee deleted successfully !";
    }

}

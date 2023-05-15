package com.example.psgrooming.service;

import com.example.psgrooming.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id) throws Exception;

    Employee createEmployee(Employee emp);
    Employee updateEmployeeById(int id,Employee emp) throws Exception;
    void deleteEmployeeById(int id) throws Exception;
}

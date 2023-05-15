package com.example.psgrooming.service.implementation;

import com.example.psgrooming.model.Employee;
import com.example.psgrooming.repository.EmployeeRepository;
import com.example.psgrooming.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) throws Exception{
        Optional<Employee> employee =  employeeRepository.findById(id);
        if(employee.isEmpty()){
            throw new Exception("Employee not found!");
        }
        return employee.get();
    }

    @Override
    public Employee createEmployee(Employee emp){
        return employeeRepository.save(emp);
    }

    @Override
    public Employee updateEmployeeById(int id, Employee emp) throws Exception{
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()){
            throw new Exception("Employee not found!");
        }
        Employee UpdatesEmp = employee.get();
        UpdatesEmp.setName(emp.getName());
        UpdatesEmp.setEmailID(emp.getEmailID());
        UpdatesEmp.setSalary(emp.getSalary());
        employeeRepository.save(UpdatesEmp);
        return UpdatesEmp;
    }

    @Override
    public void deleteEmployeeById(int id) throws Exception{
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()){
            throw new Exception("Employee not found!");
        }
        employeeRepository.deleteById(id);
    }
}

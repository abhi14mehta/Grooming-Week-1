package com.example.psgrooming.controller;

import com.example.psgrooming.model.Employee;
import com.example.psgrooming.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
//    public List<Employee> getAllEmployees(){
//        return employeeService.getAllEmployees();
//    }

    public ResponseEntity<CollectionModel<EntityModel<Employee>>> getAllEmployees() {
        List<EntityModel<Employee>> employees = employeeService.getAllEmployees().stream()
                .map(employee -> EntityModel.of(employee,
                        Link.of(String.format("/employees/%d", employee.getEmployeeId())).withSelfRel(),
                        Link.of(String.format("/employees/update/%d", employee.getEmployeeId())).withRel("update employee"),
                        Link.of(String.format("/employees/%d", employee.getEmployeeId())).withRel("delete employee")
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(employees,
                Link.of("/employees/").withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Employee>> getAllEmployeeById(@PathVariable("id") Integer id) throws Exception {
        Employee employee = this.employeeService.getEmployeeById(id);
//        employee.add()
        EntityModel<Employee> employeeModel = EntityModel.of(employee,
                Link.of(String.format("/employees/%d", id)).withSelfRel(),
                Link.of(String.format("/employees/update/%d", employee.getEmployeeId())).withRel("update employee"),
                Link.of(String.format("/employees/%d", employee.getEmployeeId())).withRel("delete employee")
        );

        return ResponseEntity.ok(employeeModel);
//        return this.employeeService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<EntityModel<Employee>> createEmployee(@RequestBody Employee employee) {
//        return this.employeeService.createEmployee(employee);
        Employee newEmployee = employeeService.createEmployee(employee);
        EntityModel<Employee> employeeModel = EntityModel.of(newEmployee,
                Link.of(String.format("/employees/%d", newEmployee.getEmployeeId())).withSelfRel(),
                Link.of(String.format("/employees/update/%d", employee.getEmployeeId())).withRel("update employee"),
                Link.of(String.format("/employees/%d", employee.getEmployeeId())).withRel("delete employee")
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeModel);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<EntityModel<Employee>> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) throws Exception {
//        return this.employeeService.updatedEmployeeById(id, employee);
        Employee updatedEmployee = employeeService.updateEmployeeById(id, employee);
        EntityModel<Employee> employeeModel = EntityModel.of(updatedEmployee,
                Link.of(String.format("/employees/%d", id)).withSelfRel(),
                Link.of(String.format("/employees/%d", employee.getEmployeeId())).withRel("delete employee"));

        return ResponseEntity.ok(employeeModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id) throws Exception {
//        this.employeeService.deleteEmployeeById(id);
//        return "Successfully deleted";
        employeeService.deleteEmployeeById(id);

        return ResponseEntity.ok("Successfully deleted!");
    }

}

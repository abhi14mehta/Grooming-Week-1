package com.example.psgrooming.repository;

import com.example.psgrooming.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {

}

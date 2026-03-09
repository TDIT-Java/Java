package com.example.firstSpringBoot.repository;

import com.example.firstSpringBoot.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    public Employee getEmployee(Integer id){
        // DB Operation, fetch the details for DB
        return new Employee(1,"Pradeep", "IT", 24);
    }
}

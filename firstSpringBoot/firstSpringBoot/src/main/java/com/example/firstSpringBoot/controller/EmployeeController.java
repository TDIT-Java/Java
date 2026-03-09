package com.example.firstSpringBoot.controller;

import com.example.firstSpringBoot.dto.EmployeeDTO;
import com.example.firstSpringBoot.entity.Employee;
import com.example.firstSpringBoot.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer id){
        EmployeeDTO employeeDTO = employeeService.getEmployee(id);
        log.info("Inside getEmployee method");
        return ResponseEntity.ok(employeeDTO);
    }
}

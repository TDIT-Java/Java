package com.example.firstSpringBoot.service;

import com.example.firstSpringBoot.dto.EmployeeDTO;
import com.example.firstSpringBoot.entity.Employee;
import com.example.firstSpringBoot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeDTO getEmployee(Integer id) {
        // Business operations
        Employee employee = employeeRepository.getEmployee(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        return employeeDTO.EmployeeMapper(employee);
    }
}

package com.RedisUsage.service;

import com.RedisUsage.dto.request.EmployeeDTO;
import com.RedisUsage.dto.response.EmployeeResponseDTO;
import com.RedisUsage.entity.Employee;
import com.RedisUsage.mapper.EmployeeMapper;
import com.RedisUsage.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper empMapper;

    public EmployeeResponseDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee entity = empMapper.toEntity(employeeDTO);
        EmployeeResponseDTO empResponseDTO = empMapper.toEmployeeResponseDTO(employeeRepository.save(entity));
        log.info("Employee Added Successfully");
        return empResponseDTO;
    }

    @Cacheable(value = "employee", key = "#id")
    public EmployeeResponseDTO getEmployeeById(Integer id) {
        log.info("Employee with user ID {} not found in Redis so fetching from DB ", id);
        EmployeeResponseDTO emp = employeeRepository.findById(id)
                .map(empMapper::toEmployeeResponseDTO)
                .orElse(null);

        return emp != null ? emp : null;
    }
}

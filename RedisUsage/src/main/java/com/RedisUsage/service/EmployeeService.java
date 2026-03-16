package com.RedisUsage.service;

import com.RedisUsage.dto.request.EmployeeDTO;
import com.RedisUsage.dto.response.EmployeeResponseDTO;
import com.RedisUsage.entity.Employee;
import com.RedisUsage.mapper.EmployeeMapper;
import com.RedisUsage.repository.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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

    @Cacheable(value = "employee", key = "#id", unless = "#result == null")
    public EmployeeResponseDTO getEmployeeById(Integer id) {
        log.info("Employee with user ID {} not found in Redis so fetching from DB ", id);
        EmployeeResponseDTO emp = employeeRepository.findById(id)
                .map(empMapper::toEmployeeResponseDTO)
                .orElse(null);

        return emp != null ? emp : null;
    }

    @CachePut(value = "employee", key = "#employeeDTO.id", unless = "#result == null")
    public EmployeeResponseDTO updateEmployeeById(EmployeeDTO employeeDTO) {
        Employee empEntity = employeeRepository.findById(employeeDTO.getId())
                .orElse(null);

        if (empEntity == null) {
            log.warn("Employee not found with ID: {}", employeeDTO.getId());
            return null;
        }

        empMapper.updateEmployeeFromDTO(employeeDTO, empEntity);

        Employee savedEntity = employeeRepository.save(empEntity);

        log.info("Employee with ID: {} updated in DB and REDIS CACHE", employeeDTO.getId());

        return empMapper.toEmployeeResponseDTO(savedEntity);
    }

    @CacheEvict(value = "employee", key = "#id")
    public EmployeeResponseDTO deleteEmployeeById(@Valid Integer id) {
        Employee empEntity = employeeRepository.findById(id)
                .orElse(null);

        if (empEntity == null) {
            log.warn("Employee not found with ID: {}", id);
            return null;
        }

        employeeRepository.deleteById(id);
        log.info("Employee with ID: {} deleted from DB and REMOVED from REDIS CACHE", id);

        return empMapper.toEmployeeResponseDTO(empEntity);
    }
}

package com.RedisUsage.mapper;

import com.RedisUsage.dto.request.EmployeeDTO;
import com.RedisUsage.dto.response.EmployeeResponseDTO;
import com.RedisUsage.entity.Employee;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeeDTO empDTO);

    EmployeeDTO toDto(Employee emp);

    EmployeeResponseDTO toEmployeeResponseDTO(Employee emp);
}

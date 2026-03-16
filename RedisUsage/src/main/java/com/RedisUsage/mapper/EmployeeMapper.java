package com.RedisUsage.mapper;

import com.RedisUsage.dto.request.EmployeeDTO;
import com.RedisUsage.dto.response.EmployeeResponseDTO;
import com.RedisUsage.entity.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmployeeMapper {

    Employee toEntity(EmployeeDTO empDTO);

    EmployeeDTO toDto(Employee emp);

    EmployeeResponseDTO toEmployeeResponseDTO(Employee emp);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromDTO(EmployeeDTO employeeDTO, @MappingTarget Employee empEntity);
}

package com.RedisUsage.controller;

import com.RedisUsage.dto.request.EmployeeDTO;
import com.RedisUsage.dto.response.ApiResponse;
import com.RedisUsage.dto.response.EmployeeResponseDTO;
import com.RedisUsage.service.EmployeeService;
import com.RedisUsage.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeResponseDTO emp = employeeService.addEmployee(employeeDTO);
        return ResponseUtil.success(HttpStatus.CREATED, emp, "Employee Added Successfully");
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> getEmployee(@PathVariable @Valid Integer id) {
        EmployeeResponseDTO emp = employeeService.getEmployeeById(id);

        if (emp == null) {
            return ResponseUtil.error(HttpStatus.NOT_FOUND, "Employee Not Found with user ID " + id);
        }

        return ResponseUtil.success(HttpStatus.OK, emp, "Employee Get Successfully");
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeResponseDTO emp = employeeService.updateEmployeeById(employeeDTO);

        if (emp == null) {
            return ResponseUtil.error(HttpStatus.NOT_FOUND, "Employee Not Found with user ID " + employeeDTO.getId());
        }

        return ResponseUtil.success(HttpStatus.OK, emp, "Employee Updated Successfully");
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> deleteEmployee(@PathVariable @Valid Integer id) {

        EmployeeResponseDTO emp = employeeService.deleteEmployeeById(id);

        if (emp == null) {
            return ResponseUtil.error(HttpStatus.NOT_FOUND, "Employee Not Found with user ID " + id);
        }

        return ResponseUtil.success(HttpStatus.OK, emp, "Employee Deleted Successfully");
    }
}

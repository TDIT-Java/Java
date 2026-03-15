package com.RedisUsage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class EmployeeResponseDTO implements Serializable {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private double salary;
}

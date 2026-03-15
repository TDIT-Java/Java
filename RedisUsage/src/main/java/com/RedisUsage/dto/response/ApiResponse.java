package com.RedisUsage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ApiResponse<T> implements Serializable {
    private boolean success;
    private String message;
    private T data;
    private LocalDateTime timestamp;
}

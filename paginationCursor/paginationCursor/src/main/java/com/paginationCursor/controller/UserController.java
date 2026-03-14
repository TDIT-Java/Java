package com.paginationCursor.controller;

import com.paginationCursor.service.UserService;
import com.paginationCursor.validations.Validate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private Validate validate;

    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> getUsers(
            @Valid
            @RequestParam(required = false) Long cursor,
            @RequestParam(defaultValue = "10") int limit
    ) {
        validate.validateUrlData(cursor, limit);
        Map<String, Object> response = userService.getUsers(cursor, limit);


        if (response.containsKey("cursor") && response.get("cursor") == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(response);
    }
}

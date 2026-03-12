package com.paginationCursor.service;

import com.paginationCursor.dto.UserResponse;
import com.paginationCursor.entity.User;
import com.paginationCursor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Map<String, Object> getUsers(Long cursor, int limit) {

        List<User> users;

        if (cursor == null) {
            log.info("cursor is null and Limit is {}", limit);
            users = userRepository.findFirstPage(PageRequest.of(0, limit));
        } else {
            log.info("cursor value is {} and Limit is {}", cursor, limit);
            users = userRepository.findNextPage(cursor, PageRequest.of(0, limit));
        }

        List<UserResponse> userResponse = users.stream().map(user -> new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        )).toList();

        String nextCursor = null;
        if (!userResponse.isEmpty()) {
            Long lastUserId = userResponse.get(userResponse.size() - 1).getId();
            nextCursor = String.valueOf(lastUserId);
            log.info("nextCursor value is {} and lastUserId is {}", nextCursor, lastUserId);
        }

        log.info("Preparing response...");

        Map<String, Object> response = new HashMap<>();
        response.put("users", userResponse);
        response.put("cursor", nextCursor);

        log.info("Response is ready to send");

        return response;
    }
}

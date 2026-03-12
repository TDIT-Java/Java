package com.paginationCursor.validations;

import com.paginationCursor.exceptions.InvalidCursorException;
import com.paginationCursor.exceptions.InvalidLimitException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Validate {
    public void validateUrlData(Long cursor, Integer limit) {
        if (limit != null) {
            if (limit < 1 || limit > 100) {
                log.error("Invalid limit value {}", limit);
                throw new InvalidLimitException("Limit must be between 1 to 100");
            }
        }

        if (cursor != null) {
            if (cursor < 0) {
                log.error("Invalid cursor value {}", cursor);
                throw new InvalidCursorException("Cursor length must be greater than 0");
            }
        }

    }
}

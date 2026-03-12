package com.paginationCursor.repository;

import com.paginationCursor.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Initial Query : Get first N users
    @Query("SELECT u FROM User u ORDER BY u.id ASC")
    List<User> findFirstPage(Pageable pageable);

    // Next Page Query : Get N users where id > cursor
    @Query("SELECT u FROM User u WHERE u.id > :cursor ORDER BY u.id ASC")
    List<User> findNextPage(@Param("cursor") Long cursor, Pageable pageable);

}

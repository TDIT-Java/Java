package com.bookstore.dto;

import com.bookstore.entity.Book;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private List<Book> books;
    private int totalPages;
    private long totalElements;

}

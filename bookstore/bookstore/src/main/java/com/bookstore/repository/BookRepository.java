package com.bookstore.repository;

import com.bookstore.dto.BookFilterRequest;
import com.bookstore.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findAll(BookFilterRequest filter) {
        StringBuilder query = new StringBuilder("select b from Book b ");

        List<String> conditions = new ArrayList<>();

        if (filter.getKeyword() != null && !filter.getKeyword().isEmpty()) {
            conditions.add("(LOWER(b.title) LIKE :keyword OR LOWER(b.author) LIKE :keyword)");
        }

        if (filter.getMinPrice() != null) {
            conditions.add("b.price >= :minPrice");
        }

        if (filter.getMaxPrice() != null) {
            conditions.add("b.price <= :maxPrice");
        }

        if (filter.getMinPrice() != null) {
            conditions.add("b.price >= :minPrice");
        }

        if (filter.getMaxPrice() != null) {
            conditions.add("b.price <= :maxPrice");
        }

        if (filter.getCategory() != null && !filter.getCategory().isEmpty()) {
            conditions.add("b.category = :category");
        }

        if (filter.getMinRating() != null) {
            conditions.add("b.rating >= :minRating");
        }

        if (filter.getInStock() != null) {
            conditions.add("b.inStock = :inStock");
        }

        if (!conditions.isEmpty()) {
            query.append(" where ");
            query.append(String.join(" AND ", conditions));
        }

        String sortBy = filter.getSortBy() != null ? filter.getSortBy() : " id";
        String sortOrder = "desc".equalsIgnoreCase(filter.getSortOrder()) ? "DESC" : "ASC";
        query.append(" ORDER BY b." + sortBy + " " + sortOrder);

        TypedQuery<Book> fullQuery = entityManager.createQuery(query.toString(), Book.class);

        if (filter.getKeyword() != null && !filter.getKeyword().isEmpty()) {
            fullQuery.setParameter("keyword", "%" + filter.getKeyword().toLowerCase() + "%");
        }

        if (filter.getMinPrice() != null) {
            fullQuery.setParameter("minPrice", filter.getMinPrice());
        }

        if (filter.getMaxPrice() != null) {
            fullQuery.setParameter("maxPrice", filter.getMaxPrice());
        }

        if (filter.getCategory() != null && !filter.getCategory().isEmpty()) {
            fullQuery.setParameter("category", filter.getCategory());
        }

        if (filter.getMinRating() != null) {
            fullQuery.setParameter("minRating", filter.getMinRating());
        }

        if (filter.getInStock() != null) {
            fullQuery.setParameter("inStock", filter.getInStock());
        }

        fullQuery.setFirstResult(filter.getPage());
        fullQuery.setMaxResults(filter.getSize());

        return fullQuery.getResultList();
    }
}

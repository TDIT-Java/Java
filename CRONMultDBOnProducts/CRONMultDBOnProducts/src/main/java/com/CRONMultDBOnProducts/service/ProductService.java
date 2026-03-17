package com.CRONMultDBOnProducts.service;

import com.CRONMultDBOnProducts.dto.ProductDTO;
import com.CRONMultDBOnProducts.entity.Product;
import com.CRONMultDBOnProducts.repository.postgresql.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(ProductDTO productDTO) {

        Product product = Product.builder().name(productDTO.getName()).category(productDTO.getCategory()).price(productDTO.getPrice()).quantity(productDTO.getQuantity()).build();

        Product savedProduct = productRepository.save(product);
        log.info("Product saved to PostgreSQL with ID: {}", savedProduct.getId());

        return savedProduct;
    }
}

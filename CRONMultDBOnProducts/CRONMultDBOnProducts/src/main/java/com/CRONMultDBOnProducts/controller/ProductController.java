package com.CRONMultDBOnProducts.controller;

import com.CRONMultDBOnProducts.dto.ApiResponse;
import com.CRONMultDBOnProducts.dto.ProductDTO;
import com.CRONMultDBOnProducts.entity.Product;
import com.CRONMultDBOnProducts.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<ApiResponse<Product>> addProduct(@RequestBody ProductDTO productDTO) {

        Product savedProduct = productService.addProduct(productDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Product added successfully to PostgreSQL", savedProduct));
    }

}

package com.pricecomparator.catalog.controller;



import com.pricecomparator.catalog.dto.CreateProductRequest;
import com.pricecomparator.catalog.dto.ProductResponse;
import com.pricecomparator.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductResponse create(@RequestBody CreateProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping
    public List<ProductResponse> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable UUID id) {
        return productService.getProductById(id);
    }
}

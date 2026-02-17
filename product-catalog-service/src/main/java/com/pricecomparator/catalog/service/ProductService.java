package com.pricecomparator.catalog.service;


import com.pricecomparator.catalog.dto.CreateProductRequest;
import com.pricecomparator.catalog.dto.ProductResponse;
import com.pricecomparator.catalog.entity.Product;
import com.pricecomparator.catalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public ProductResponse createProduct(CreateProductRequest request) {

        // Convert DTO → Entity
        Product product = Product.builder()
                .title(request.getTitle())
                .brand(request.getBrand())
                .category(request.getCategory())
                .description(request.getDescription())
                .build();

        Product saved = productRepository.save(product);


        return mapToResponse(saved);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse getProductById(UUID id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return mapToResponse(product);
    }

    private ProductResponse mapToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .brand(product.getBrand())
                .category(product.getCategory())
                .description(product.getDescription())
                .createdAt(product.getCreatedAt())
                .build();
    }
}

package com.pricecomparator.catalog.dto;


import lombok.Data;

@Data
public class CreateProductRequest {

    private String title;
    private String brand;
    private String category;
    private String description;
}


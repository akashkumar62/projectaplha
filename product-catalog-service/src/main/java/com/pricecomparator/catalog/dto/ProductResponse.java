package com.pricecomparator.catalog.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ProductResponse {

    private UUID id;
    private String title;
    private String brand;
    private String category;
    private String description;
    private LocalDateTime createdAt;
}

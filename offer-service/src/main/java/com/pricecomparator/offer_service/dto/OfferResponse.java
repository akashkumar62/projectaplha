package com.pricecomparator.offer_service.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class OfferResponse {

    private UUID id;
    private UUID productId;
    private String merchantId;
    private BigDecimal price;
    private String currency;
    private Integer stock;
    private LocalDateTime createdAt;
}

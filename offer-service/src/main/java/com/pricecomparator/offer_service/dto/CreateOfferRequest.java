package com.pricecomparator.offer_service.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CreateOfferRequest {

    private UUID productId;
    private String merchantId;
    private BigDecimal price;
    private String currency;
    private Integer stock;
}

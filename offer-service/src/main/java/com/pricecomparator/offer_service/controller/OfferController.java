package com.pricecomparator.offer_service.controller;

import com.pricecomparator.offer_service.dto.CreateOfferRequest;
import com.pricecomparator.offer_service.dto.OfferResponse;
import com.pricecomparator.offer_service.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    // 1️⃣ Create Offer
    @PostMapping
    public OfferResponse createOffer(@RequestBody CreateOfferRequest request) {
        return offerService.createOffer(request);
    }

    // 2️⃣ Get Offer By ID
    @GetMapping("/{id}")
    public OfferResponse getOfferById(@PathVariable UUID id) {
        return offerService.getOfferById(id);
    }

    // 3️⃣ Get All Offers For A Product
    @GetMapping("/product/{productId}")
    public List<OfferResponse> getOffersByProduct(@PathVariable UUID productId) {
        return offerService.getOffersByProduct(productId);
    }

    // 4️⃣ Get All Offers By Merchant
    @GetMapping("/merchant/{merchantId}")
    public List<OfferResponse> getOffersByMerchant(@PathVariable String merchantId) {
        return offerService.getOffersByMerchant(merchantId);
    }

    // 5️⃣ Delete Offer
    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable UUID id) {
        offerService.deleteOffer(id);
    }
}

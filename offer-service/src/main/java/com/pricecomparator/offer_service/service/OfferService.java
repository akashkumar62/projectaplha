package com.pricecomparator.offer_service.service;

import com.pricecomparator.offer_service.dto.CreateOfferRequest;
import com.pricecomparator.offer_service.dto.OfferResponse;
import com.pricecomparator.offer_service.entity.Offer;
import com.pricecomparator.offer_service.repository.OfferRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;


    public OfferResponse createOffer(CreateOfferRequest request) {

        Offer offer = Offer.builder()
                .productId(request.getProductId())
                .merchantId(request.getMerchantId())
                .price(request.getPrice())
                .currency(request.getCurrency())
                .stock(request.getStock())
                .build();

        Offer saved = offerRepository.save(offer);


        return mapToResponse(saved);
    }

    public OfferResponse getOfferById(UUID id) {
        Offer offer = offerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer not found"));
        return mapToResponse(offer);
    }

    public List<OfferResponse> getOffersByMerchant(String merchantId) {
        return offerRepository.findByMerchantId(merchantId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public void deleteOffer(UUID id) {
        offerRepository.deleteById(id);
    }

    public List<OfferResponse> getOffersByProduct(UUID productId) {

        return offerRepository.findByProductId(productId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private OfferResponse mapToResponse(Offer offer) {
        return OfferResponse.builder()
                .id(offer.getId())
                .productId(offer.getProductId())
                .merchantId(offer.getMerchantId())
                .price(offer.getPrice())
                .currency(offer.getCurrency())
                .stock(offer.getStock())
                .createdAt(offer.getCreatedAt())
                .build();
    }
}

package com.pricecomparator.offer_service.repository;


import com.pricecomparator.offer_service.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {

    // Get all offers for a specific product
    List<Offer> findByProductId(UUID productId);

    // Get all offers by merchant
    List<Offer> findByMerchantId(String merchantId);

    // Optional: delete all offers for a product (useful later)
    void deleteByProductId(UUID productId);
}
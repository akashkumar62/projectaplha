package com.pricecomparator.catalog.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

 @Id
 @GeneratedValue(strategy = GenerationType.UUID)
 private UUID id;

 private String title;
 private String brand;
 private String category;

 @Column(length = 3000)
 private String description;

 private LocalDateTime createdAt;
 private LocalDateTime updatedAt;

 @PrePersist
 public void prePersist() {
  this.createdAt = LocalDateTime.now();
  this.updatedAt = LocalDateTime.now();
 }

 @PreUpdate
 public void preUpdate() {
  this.updatedAt = LocalDateTime.now();
 }
}

package com.ecommerce.deals.LimitedTimeDeals.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dealId;

    private String name;

    private int maxQuantity;

    private int claimedQuantity;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private double price;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}

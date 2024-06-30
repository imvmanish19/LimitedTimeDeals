package com.ecommerce.deals.LimitedTimeDeals.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    private String name;

    private String description;

    private double price;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}

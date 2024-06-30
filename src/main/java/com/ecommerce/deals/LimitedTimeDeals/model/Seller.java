package com.ecommerce.deals.LimitedTimeDeals.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sellerId;

    private String name;

    private String email;

    @OneToMany(mappedBy = "seller")
    private List<Item> items;

    @OneToMany(mappedBy = "seller")
    private List<Deal> deals;


}

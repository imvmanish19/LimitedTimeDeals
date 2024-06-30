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
public class DealClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int claimId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @OneToOne
    @JoinColumn(name = "deal_id")
    private Deal deal;

    private LocalDateTime claimTime;

    private int quantity;
}

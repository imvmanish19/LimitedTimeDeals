package com.ecommerce.deals.LimitedTimeDeals.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DealRequest {

    private String dealName;

    private int maxQuantity;

    private LocalDateTime endTime;

    private double price;

    private int sellerId;

    private int timePeriodInHours;
}

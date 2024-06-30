package com.ecommerce.deals.LimitedTimeDeals.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerRequest {
    private int sellerId;

    private String name;

    private String email;
}

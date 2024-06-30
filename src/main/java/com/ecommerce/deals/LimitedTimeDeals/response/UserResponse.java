package com.ecommerce.deals.LimitedTimeDeals.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private GenericResponse genericResponse;

    private Integer userId;
}


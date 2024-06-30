package com.ecommerce.deals.LimitedTimeDeals.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DealResponse {
    private GenericResponse genericResponse;

    private Integer dealId;
}


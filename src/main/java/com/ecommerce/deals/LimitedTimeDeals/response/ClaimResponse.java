package com.ecommerce.deals.LimitedTimeDeals.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaimResponse {
    private GenericResponse genericResponse;

    private Integer claimId;
}

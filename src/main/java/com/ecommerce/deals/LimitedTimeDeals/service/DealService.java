package com.ecommerce.deals.LimitedTimeDeals.service;

import com.ecommerce.deals.LimitedTimeDeals.request.DealRequest;
import com.ecommerce.deals.LimitedTimeDeals.response.DealResponse;
import com.ecommerce.deals.LimitedTimeDeals.response.GenericResponse;

import java.time.LocalDateTime;

public interface DealService {
    DealResponse addDeal(DealRequest dealRequest);

    GenericResponse endDeal(int dealId);

    GenericResponse updateDeal(int dealId, Integer maxQuantity, String updatedTime);
}

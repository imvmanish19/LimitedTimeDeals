package com.ecommerce.deals.LimitedTimeDeals.service;

import com.ecommerce.deals.LimitedTimeDeals.request.SellerRequest;
import com.ecommerce.deals.LimitedTimeDeals.response.SellerResponse;

public interface SellerService {
    SellerResponse addSeller(SellerRequest sellerRequest);
}

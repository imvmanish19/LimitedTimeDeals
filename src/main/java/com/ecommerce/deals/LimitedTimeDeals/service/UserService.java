package com.ecommerce.deals.LimitedTimeDeals.service;

import com.ecommerce.deals.LimitedTimeDeals.request.UserRequest;
import com.ecommerce.deals.LimitedTimeDeals.response.ClaimResponse;
import com.ecommerce.deals.LimitedTimeDeals.response.UserResponse;

public interface UserService {
    UserResponse addUser(UserRequest userRequest);

    ClaimResponse claimDeal(Integer userId, Integer dealId);
}

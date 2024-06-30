package com.ecommerce.deals.LimitedTimeDeals.util;

import com.ecommerce.deals.LimitedTimeDeals.model.Deal;
import com.ecommerce.deals.LimitedTimeDeals.model.Seller;
import com.ecommerce.deals.LimitedTimeDeals.model.UserProfile;
import com.ecommerce.deals.LimitedTimeDeals.request.DealRequest;
import com.ecommerce.deals.LimitedTimeDeals.request.SellerRequest;
import com.ecommerce.deals.LimitedTimeDeals.request.UserRequest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RequestConverterUtil {

    public static final int ZERO = 0;
    public static Seller convertToSellerDO(SellerRequest sellerRequest) {
        Seller seller = new Seller();
        seller.setName(sellerRequest.getName());
        seller.setEmail(sellerRequest.getEmail());
        return seller;
    }

    public static UserProfile convertToUserDO(UserRequest userRequest) {
        UserProfile userProfile = new UserProfile();
        userProfile.setName(userRequest.getName());
        userProfile.setEmail(userRequest.getEmail());
        return userProfile;
    }

    public static Deal convertToDealDO(DealRequest dealRequest) {
        Deal deal = new Deal();
        deal.setName(dealRequest.getDealName());
        deal.setMaxQuantity(dealRequest.getMaxQuantity());
        deal.setClaimedQuantity(ZERO);
        deal.setStartTime(LocalDateTime.now());
        deal.setPrice(dealRequest.getPrice());
        deal.setEndTime(LocalDateTime.now().plusHours(dealRequest.getTimePeriodInHours()));
        return deal;
    }
}

package com.ecommerce.deals.LimitedTimeDeals.service.impl;

import com.ecommerce.deals.LimitedTimeDeals.enums.ResponseEnum;
import com.ecommerce.deals.LimitedTimeDeals.exception.RestException;
import com.ecommerce.deals.LimitedTimeDeals.model.Deal;
import com.ecommerce.deals.LimitedTimeDeals.model.DealClaim;
import com.ecommerce.deals.LimitedTimeDeals.model.UserProfile;
import com.ecommerce.deals.LimitedTimeDeals.repository.DealClaimRepository;
import com.ecommerce.deals.LimitedTimeDeals.repository.DealRepository;
import com.ecommerce.deals.LimitedTimeDeals.repository.UserRepository;
import com.ecommerce.deals.LimitedTimeDeals.request.UserRequest;
import com.ecommerce.deals.LimitedTimeDeals.response.ClaimResponse;
import com.ecommerce.deals.LimitedTimeDeals.response.GenericResponse;
import com.ecommerce.deals.LimitedTimeDeals.response.UserResponse;
import com.ecommerce.deals.LimitedTimeDeals.service.UserService;
import com.ecommerce.deals.LimitedTimeDeals.util.RequestConverterUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private DealClaimRepository dealClaimRepository;

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        UserProfile userProfile = RequestConverterUtil.convertToUserDO(userRequest);
        UserProfile savedUserProfile = userRepository.save(userProfile);
        userResponse.setUserId(savedUserProfile.getUserId());
        userResponse.setGenericResponse(new GenericResponse(ResponseEnum.USER_ADDED));
        return userResponse;
    }

    @Override
    @Transactional
    public ClaimResponse claimDeal(Integer userId, Integer dealId) {
        if(Objects.isNull(userId) || Objects.isNull(dealId)) {
            throw new RestException(ResponseEnum.CLAIM_BAD_REQUEST);
        }

        Optional<DealClaim> optionalDealClaim = dealClaimRepository.findByDealIdAndUserId(dealId, userId);

        if(optionalDealClaim.isPresent()) {
            throw new RestException(ResponseEnum.DEAL_ALREADY_CLAIMED);
        }

        Optional<UserProfile> userProfile = userRepository.findById(userId);
        if(userProfile.isEmpty()) {
            throw new RestException(ResponseEnum.USER_NOT_FOUND);
        }

        Optional<Deal> deal = dealRepository.findById(dealId);
        if(deal.isEmpty()) {
            throw new RestException(ResponseEnum.DEAL_NOT_FOUND);
        }

        Deal actualDeal = deal.get();
        if(actualDeal.getMaxQuantity() == actualDeal.getClaimedQuantity() || LocalDateTime.now().isAfter(actualDeal.getEndTime())) {
            throw new RestException(ResponseEnum.DEAL_EXPIRED);
        }

        dealRepository.updateClaimedQuantity(actualDeal.getDealId(), actualDeal.getClaimedQuantity() + 1);

        DealClaim dealClaim = new DealClaim();
        dealClaim.setDeal(actualDeal);
        dealClaim.setUserProfile(userProfile.get());
        dealClaim.setQuantity(1);
        dealClaim.setClaimTime(LocalDateTime.now());
        DealClaim savedDealClaim = dealClaimRepository.save(dealClaim);
        ClaimResponse claimResponse = new ClaimResponse();
        claimResponse.setClaimId(savedDealClaim.getClaimId());
        claimResponse.setGenericResponse(new GenericResponse(ResponseEnum.CLAIMED));
        return claimResponse;
    }
}

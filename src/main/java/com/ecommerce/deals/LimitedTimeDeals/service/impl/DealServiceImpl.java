package com.ecommerce.deals.LimitedTimeDeals.service.impl;

import com.ecommerce.deals.LimitedTimeDeals.enums.ResponseEnum;
import com.ecommerce.deals.LimitedTimeDeals.exception.RestException;
import com.ecommerce.deals.LimitedTimeDeals.model.Deal;
import com.ecommerce.deals.LimitedTimeDeals.model.Seller;
import com.ecommerce.deals.LimitedTimeDeals.repository.DealRepository;
import com.ecommerce.deals.LimitedTimeDeals.repository.SellerRepository;
import com.ecommerce.deals.LimitedTimeDeals.request.DealRequest;
import com.ecommerce.deals.LimitedTimeDeals.response.DealResponse;
import com.ecommerce.deals.LimitedTimeDeals.response.GenericResponse;
import com.ecommerce.deals.LimitedTimeDeals.service.DealService;
import com.ecommerce.deals.LimitedTimeDeals.util.RequestConverterUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private SellerRepository sellerRepository;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    @Override
    public DealResponse addDeal(DealRequest dealRequest) {
        if(Objects.isNull(dealRequest) || Objects.isNull(dealRequest.getSellerId())) {
            throw new RestException(ResponseEnum.DEAL_BAD_REQUEST);
        }

        Optional<Seller> seller = sellerRepository.findById(dealRequest.getSellerId());

        if(seller.isEmpty()) {
            throw new RestException(ResponseEnum.SELLER_NOT_FOUND);
        }

        DealResponse dealResponse = new DealResponse();
        Deal deal = RequestConverterUtil.convertToDealDO(dealRequest);
        deal.setSeller(seller.get());
        Deal savedDeal = dealRepository.save(deal);
        dealResponse.setDealId(savedDeal.getDealId());
        dealResponse.setGenericResponse(new GenericResponse(ResponseEnum.DEAL_ADDED));
        return dealResponse;
    }

    @Override
    @Transactional
    public GenericResponse endDeal(int dealId) {
        Optional<Deal> dealOptional = dealRepository.findById(dealId);
        if(dealOptional.isEmpty()) {
            throw new RestException(ResponseEnum.DEAL_NOT_FOUND);
        }
        Deal deal = dealOptional.get();
        deal.setEndTime(LocalDateTime.now());
        dealRepository.save(deal);
        return new GenericResponse(ResponseEnum.DEAL_END_SUCCESS);
    }

    @Override
    @Transactional
    public GenericResponse updateDeal(int dealId, Integer maxQuantity, String updatedTime) {
        if(Objects.isNull(maxQuantity) && Objects.isNull(updatedTime)) {
            throw new RestException(ResponseEnum.DEAL_BAD_REQUEST);
        }
        Optional<Deal> dealOptional = dealRepository.findById(dealId);
        if(dealOptional.isEmpty()) {
            throw new RestException(ResponseEnum.DEAL_NOT_FOUND);
        }
        Deal deal = dealOptional.get();
        if(Objects.nonNull(maxQuantity)) {
            deal.setMaxQuantity(maxQuantity);
        }
        if(Objects.nonNull(updatedTime)) {
            LocalDateTime parsedDateTime = LocalDateTime.parse(updatedTime, DATE_TIME_FORMATTER);
            deal.setEndTime(parsedDateTime);
        }
        dealRepository.save(deal);
        return new GenericResponse(ResponseEnum.DEAL_UPDATE_SUCCESS);
    }
}

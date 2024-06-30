package com.ecommerce.deals.LimitedTimeDeals.service.impl;

import com.ecommerce.deals.LimitedTimeDeals.enums.ResponseEnum;
import com.ecommerce.deals.LimitedTimeDeals.model.Seller;
import com.ecommerce.deals.LimitedTimeDeals.repository.SellerRepository;
import com.ecommerce.deals.LimitedTimeDeals.request.SellerRequest;
import com.ecommerce.deals.LimitedTimeDeals.response.GenericResponse;
import com.ecommerce.deals.LimitedTimeDeals.response.SellerResponse;
import com.ecommerce.deals.LimitedTimeDeals.service.SellerService;
import com.ecommerce.deals.LimitedTimeDeals.util.RequestConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public SellerResponse addSeller(SellerRequest sellerRequest) {
        SellerResponse sellerResponse = new SellerResponse();
        Seller seller = RequestConverterUtil.convertToSellerDO(sellerRequest);
        Seller savedSeller = sellerRepository.save(seller);
        sellerResponse.setSellerId(savedSeller.getSellerId());
        sellerResponse.setGenericResponse(new GenericResponse(ResponseEnum.SELLER_ADDED));
        return sellerResponse;
    }
}

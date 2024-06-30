package com.ecommerce.deals.LimitedTimeDeals.controller;

import com.ecommerce.deals.LimitedTimeDeals.request.SellerRequest;
import com.ecommerce.deals.LimitedTimeDeals.response.SellerResponse;
import com.ecommerce.deals.LimitedTimeDeals.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/add")
    public ResponseEntity<SellerResponse> addSeller(@RequestBody SellerRequest sellerRequest) {
        SellerResponse sellerResponse = sellerService.addSeller(sellerRequest);
        HttpStatus httpStatus = sellerResponse.getGenericResponse().getHttpStatus();
        return ResponseEntity.status(httpStatus).body(sellerResponse);
    }
}

package com.ecommerce.deals.LimitedTimeDeals.controller;

import com.ecommerce.deals.LimitedTimeDeals.request.DealRequest;
import com.ecommerce.deals.LimitedTimeDeals.response.DealResponse;
import com.ecommerce.deals.LimitedTimeDeals.response.GenericResponse;
import com.ecommerce.deals.LimitedTimeDeals.response.SellerResponse;
import com.ecommerce.deals.LimitedTimeDeals.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/deals")
public class DealController {

    @Autowired
    private DealService dealService;


    @PostMapping("/add")
    public ResponseEntity<DealResponse> addDeal(@RequestBody DealRequest dealRequest) {
        DealResponse dealResponse = dealService.addDeal(dealRequest);
        HttpStatus httpStatus = dealResponse.getGenericResponse().getHttpStatus();
        return ResponseEntity.status(httpStatus).body(dealResponse);
    }

    @PostMapping("/end/{id}")
    public ResponseEntity<GenericResponse> addDeal(@PathVariable int id) {
        GenericResponse genericResponse = dealService.endDeal(id);
        HttpStatus httpStatus = genericResponse.getHttpStatus();
        return ResponseEntity.status(httpStatus).body(genericResponse);
    }

    // INSERT INTO ITEM VALUES(1, 'Cricket Bat', 'Bat', 200.0, 1);
    @PostMapping("/update")
    public ResponseEntity<GenericResponse> updateDeal(@RequestParam int dealId, @RequestParam(required = false) Integer maxQuantity, @RequestParam(required = false) String updatedTime) {
        GenericResponse genericResponse = dealService.updateDeal(dealId, maxQuantity, updatedTime);
        HttpStatus httpStatus = genericResponse.getHttpStatus();
        return ResponseEntity.status(httpStatus).body(genericResponse);
    }
}

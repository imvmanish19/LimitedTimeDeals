package com.ecommerce.deals.LimitedTimeDeals.controller;

import com.ecommerce.deals.LimitedTimeDeals.request.SellerRequest;
import com.ecommerce.deals.LimitedTimeDeals.request.UserRequest;
import com.ecommerce.deals.LimitedTimeDeals.response.ClaimResponse;
import com.ecommerce.deals.LimitedTimeDeals.response.GenericResponse;
import com.ecommerce.deals.LimitedTimeDeals.response.SellerResponse;
import com.ecommerce.deals.LimitedTimeDeals.response.UserResponse;
import com.ecommerce.deals.LimitedTimeDeals.service.SellerService;
import com.ecommerce.deals.LimitedTimeDeals.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponse> addSeller(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.addUser(userRequest);
        HttpStatus httpStatus = userResponse.getGenericResponse().getHttpStatus();
        return ResponseEntity.status(httpStatus).body(userResponse);
    }

    @PostMapping("{userId}/claim/{dealId}")
    public ResponseEntity<ClaimResponse> addSeller(@PathVariable Integer userId, @PathVariable Integer dealId) {
        ClaimResponse claimResponse = userService.claimDeal(userId, dealId);
        HttpStatus httpStatus = claimResponse.getGenericResponse().getHttpStatus();
        return ResponseEntity.status(httpStatus).body(claimResponse);
    }
}

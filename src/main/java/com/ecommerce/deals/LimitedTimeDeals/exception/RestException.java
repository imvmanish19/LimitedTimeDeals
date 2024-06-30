package com.ecommerce.deals.LimitedTimeDeals.exception;

import com.ecommerce.deals.LimitedTimeDeals.enums.ResponseEnum;

public class RestException extends RuntimeException {

    private ResponseEnum responseEnum;

    public RestException() {

    }

    public RestException(ResponseEnum responseEnum) {
        this.responseEnum = responseEnum;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }

    public void setResponseEnum(ResponseEnum responseEnum) {
        this.responseEnum = responseEnum;
    }
}

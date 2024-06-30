package com.ecommerce.deals.LimitedTimeDeals.enums;

import org.springframework.http.HttpStatus;

public enum ResponseEnum {

    /** SELLER **/
    SELLER_ADDED("BE100", "Seller Added Successfully", HttpStatus.CREATED),

    SELLER_NOT_FOUND("BE101", "Seller not found", HttpStatus.NOT_FOUND),

    /** USER **/
    USER_ADDED("BE200", "User Added Successfully", HttpStatus.CREATED),

    USER_NOT_FOUND("BE201", "User Not Found", HttpStatus.NOT_FOUND),

    /** DEAL **/

    DEAL_BAD_REQUEST("BE301", "Deal Request is empty", HttpStatus.BAD_REQUEST),

    DEAL_ADDED("BE300", "Deal Added", HttpStatus.CREATED),

    DEAL_NOT_FOUND("BE303", "Deal not found", HttpStatus.NOT_FOUND),

    DEAL_END_SUCCESS("BE303", "Deal ended successfully", HttpStatus.OK),

    DEAL_UPDATE_SUCCESS("BE304", "Deal updated successfully", HttpStatus.OK),

    DEAL_EXPIRED("BE305", "Deal expired", HttpStatus.OK),



    /** CLAIM **/
    CLAIMED("BE400", "Deal Claimed successfully", HttpStatus.OK),

    CLAIM_BAD_REQUEST("BE401", "Claim Request is not proper", HttpStatus.BAD_REQUEST),

    DEAL_ALREADY_CLAIMED("BE407", "Deal Already Claimed by User.", HttpStatus.OK),


    ;


    private String responseCode;
    private String message;

    private HttpStatus httpStatus;

    ResponseEnum(String responseCode, String message, HttpStatus httpStatus) {
        this.responseCode = responseCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}

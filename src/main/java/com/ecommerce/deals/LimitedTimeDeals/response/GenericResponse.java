package com.ecommerce.deals.LimitedTimeDeals.response;

import com.ecommerce.deals.LimitedTimeDeals.enums.ResponseEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GenericResponse {
    private String message;
    private String responseCode;

    @JsonIgnore
    private HttpStatus httpStatus;

    public GenericResponse(ResponseEnum responseEnum) {
        this.message = responseEnum.getMessage();
        this.httpStatus = responseEnum.getHttpStatus();
        this.responseCode = responseEnum.getResponseCode();
    }
}

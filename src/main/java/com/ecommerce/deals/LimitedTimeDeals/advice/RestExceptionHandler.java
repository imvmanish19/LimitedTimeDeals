package com.ecommerce.deals.LimitedTimeDeals.advice;

import com.ecommerce.deals.LimitedTimeDeals.exception.RestException;
import com.ecommerce.deals.LimitedTimeDeals.response.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<GenericResponse> handleRestException(RestException exception) {
        GenericResponse genericResponse = new GenericResponse(exception.getResponseEnum());
        return ResponseEntity.status(genericResponse.getHttpStatus()).body(genericResponse);
    }
}

package com.emazon.supply.configuration.exceptionhandler;

import com.emazon.supply.domain.exceptions.SupplyQuantityNotBeZeroException;
import com.emazon.supply.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class SupplyControllerAdvisor {

    @ExceptionHandler(SupplyQuantityNotBeZeroException.class)
    public ResponseEntity<ExceptionResponse> handleSupplyQuantityNotBeZeroException(SupplyQuantityNotBeZeroException ex) {
        return ResponseEntity.badRequest().body(
                new ExceptionResponse(Constants.EXCEPTION_SUPPLY_QUANTITY_ZERO, HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now())
        );
    }

}

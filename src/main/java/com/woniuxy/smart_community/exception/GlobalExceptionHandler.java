package com.woniuxy.smart_community.exception;

import com.woniuxy.smart_community.entity.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity doException(Exception ex) {
        System.out.println("GlobalExceptionHandler.doException");
        return new ResponseEntity(500,ex.getMessage(),null);
    }
}

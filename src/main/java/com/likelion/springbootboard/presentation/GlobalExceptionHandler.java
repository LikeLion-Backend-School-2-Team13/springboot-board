package com.likelion.springbootboard.presentation;

import com.likelion.springbootboard.dto.ErrorResponse;
import com.likelion.springbootboard.exception.AbstractHttpErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AbstractHttpErrorException.class)
    public ResponseEntity<ErrorResponse> httpErrorExceptionHandle(AbstractHttpErrorException e) {
        return e.toErrorResponse().toResponseEntity();
    }
}

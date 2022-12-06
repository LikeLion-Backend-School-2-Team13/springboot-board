package com.likelion.springbootboard.exception;

import com.likelion.springbootboard.dto.ErrorResponse;
import org.springframework.http.HttpStatus;

public abstract class AbstractHttpErrorException extends RuntimeException{
    private final HttpStatus httpStatus;

    public AbstractHttpErrorException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.httpStatus = errorCode.getHttpStatus();
    }

    public ErrorResponse toErrorResponse() {
        return new ErrorResponse(httpStatus.value(), httpStatus.getReasonPhrase(), getMessage());
    }
}

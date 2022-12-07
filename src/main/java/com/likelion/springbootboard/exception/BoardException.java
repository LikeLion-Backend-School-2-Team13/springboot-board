package com.likelion.springbootboard.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BoardException extends RuntimeException{
    private ErrorCode errorCode;
    private String message;

    public String toString() {
        if (message==null)return errorCode.getMessage();
        return String.format("%s. %s", errorCode.getMessage(), message);
    }

}

package com.likelion.springbootboard.dto;

import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
public class ErrorResponse {
    private int code;
    private String type;
    private String message;

    private ErrorResponse() {
    }

    public ErrorResponse(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public ResponseEntity<ErrorResponse> toResponseEntity() {
        return ResponseEntity.status(code)
                            .body(this);
    }
}

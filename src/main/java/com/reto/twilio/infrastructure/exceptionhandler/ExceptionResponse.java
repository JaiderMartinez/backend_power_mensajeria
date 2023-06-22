package com.reto.twilio.infrastructure.exceptionhandler;

public enum ExceptionResponse {

    TOKEN_INVALID("The token is invalid");

    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
package com.reto.twilio.infrastructure.configurations.security.jwt.exceptions;

public class ParseTokenException extends RuntimeException{

    public ParseTokenException() {
        super("Token parse failed");
    }
}

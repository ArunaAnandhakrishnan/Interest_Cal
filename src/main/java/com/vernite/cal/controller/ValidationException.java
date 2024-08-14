package com.vernite.cal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(HttpStatus httpStatus, String actorNotFound, Exception ex) {
    }

    public ValidationException(HttpStatus httpStatus, String s) {
    }
}

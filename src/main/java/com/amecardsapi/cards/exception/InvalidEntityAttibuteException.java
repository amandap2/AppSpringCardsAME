package com.amecardsapi.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidEntityAttibuteException extends RuntimeException {
    public InvalidEntityAttibuteException(String message) {
        super(message);
    }
}

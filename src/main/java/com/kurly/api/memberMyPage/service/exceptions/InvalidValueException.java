package com.kurly.api.memberMyPage.service.exceptions;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException(String message) {
        super(message);
    }
}

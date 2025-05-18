package com.example.fund.model.exception;

public class ResourseNotFoundException extends RuntimeException {
    public ResourseNotFoundException(String message) {
        super(message);
    }
}

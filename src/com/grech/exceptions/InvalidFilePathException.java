package com.grech.exceptions;

public class InvalidFilePathException extends RuntimeException {
    public InvalidFilePathException(String message) {
        super(message);
    }
}

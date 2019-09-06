package com.stackroute.exceptions;

/**
 * Custom Exception to throw if track already exists
 */
public class TrackAlreadyExistsException extends Exception{
    private String message;

    public TrackAlreadyExistsException() {
    }

    public TrackAlreadyExistsException(String message) {
        this.message = message;
    }
}

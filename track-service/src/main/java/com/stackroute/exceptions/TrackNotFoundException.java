package com.stackroute.exceptions;

/**
 * Custom Exception to throw if track is not found
 */
public class TrackNotFoundException extends Exception{
    private String message;

    public TrackNotFoundException() {
    }

    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}

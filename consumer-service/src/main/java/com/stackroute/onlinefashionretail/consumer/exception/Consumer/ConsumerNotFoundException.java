package com.stackroute.onlinefashionretail.consumer.exception.Consumer;

public class ConsumerNotFoundException extends Exception {
    public ConsumerNotFoundException() {
    }

    public ConsumerNotFoundException(String message) {
        super(message);
    }

    public ConsumerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

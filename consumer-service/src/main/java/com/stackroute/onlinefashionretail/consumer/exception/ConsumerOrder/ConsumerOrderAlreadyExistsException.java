package com.stackroute.onlinefashionretail.consumer.exception.ConsumerOrder;

public class ConsumerOrderAlreadyExistsException extends Exception {
    public ConsumerOrderAlreadyExistsException() {
        super();
    }

    public ConsumerOrderAlreadyExistsException(String message) {
        super(message);
    }

    public ConsumerOrderAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

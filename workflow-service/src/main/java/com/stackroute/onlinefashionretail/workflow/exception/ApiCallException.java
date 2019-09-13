package com.stackroute.onlinefashionretail.workflow.exception;

public class ApiCallException extends Exception {
    public ApiCallException() {
    }

    public ApiCallException(String message) {
        super(message);
    }

    public ApiCallException(String message, Throwable cause) {
        super(message, cause);
    }
}

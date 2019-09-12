package com.stackroute.onlinefashionretail.workflow.controller;

import com.stackroute.onlinefashionretail.workflow.exception.ApiCallException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//ControllerAdvice class to handle exceptions globally
@ControllerAdvice("com.stackroute.onlinefashionretail.workflow")
public class WorkflowControllerAdvice extends ResponseEntityExceptionHandler {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    //Exception Handler for ApiCallException
    @ExceptionHandler(value = {ApiCallException.class})
    protected ResponseEntity<Object> handleNotFoundConflict(Exception ex, WebRequest request) {
        logger.error("Caught Api Call Exception");
        String bodyOfResponse = "Error connecting to api!: "+ex.toString();
        return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}



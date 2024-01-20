package com.bloggersApp.bloggers.exceptions;

import com.bloggersApp.bloggers.responsePayloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// Spring will make this class as the handler for all the exceptions which we will get from all the controllers
public class ExceptionsHandler {


    // it will ensure that for this type of exception this method is called
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException){
        ApiResponse apiResponse = new ApiResponse(resourceNotFoundException.getMessage(),false, "");

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}

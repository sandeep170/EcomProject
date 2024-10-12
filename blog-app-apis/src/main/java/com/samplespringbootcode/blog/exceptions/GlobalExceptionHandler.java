package com.samplespringbootcode.blog.exceptions;

import com.samplespringbootcode.blog.payloads.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        String message = ex.getMessage();
        APIResponse apiResponse = new APIResponse(message,false);
        return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String, String> exceptionResponse = new HashMap<>();

        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((ex) -> {
           String fieldName = ((FieldError)ex).getField();
           String defaultMessage = ex.getDefaultMessage();
           exceptionResponse.put(fieldName,defaultMessage);
        });
        return new ResponseEntity<Map<String, String>>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}

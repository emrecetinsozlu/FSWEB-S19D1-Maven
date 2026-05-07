package com.workintech.s18d2.exceptions;


import org.hibernate.query.NativeQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler{
    @ExceptionHandler(PlantException.class)
    public ResponseEntity<PlantErrorMessage> handlePlantException(PlantException plantException) {
        PlantErrorMessage plantErrorMessage = new PlantErrorMessage(plantException.getMessage(),plantException.getHttpStatus());
        return  new ResponseEntity<>(plantErrorMessage,plantException.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<PlantErrorMessage> throwable(Exception exception){
        PlantErrorMessage plantErrorMessage = new PlantErrorMessage(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return  new ResponseEntity<>(plantErrorMessage,HttpStatus.BAD_REQUEST);
    }
}

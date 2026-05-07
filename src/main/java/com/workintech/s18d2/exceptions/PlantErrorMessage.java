package com.workintech.s18d2.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class PlantErrorMessage {
    private String message;
    private HttpStatus status;

    public PlantErrorMessage(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}

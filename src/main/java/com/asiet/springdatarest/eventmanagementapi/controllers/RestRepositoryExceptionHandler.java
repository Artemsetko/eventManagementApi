package com.asiet.springdatarest.eventmanagementapi.controllers;

import com.asiet.springdatarest.eventmanagementapi.controllers.exceptions.AlreadyCheckedInException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestRepositoryExceptionHandler {

    @ExceptionHandler(AlreadyCheckedInException.class)
    public ResponseEntity handleApplicationException(AlreadyCheckedInException e) {
        return ResponseEntity.status(400).body("Already checked in");
    }
}
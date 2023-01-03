package com.asiet.springdatarest.eventmanagementapi.controllers.exceptions;

public class AlreadyCheckedInException extends RuntimeException {

    public AlreadyCheckedInException(String alreadyCheckIN) {
        super(alreadyCheckIN);
    }
}

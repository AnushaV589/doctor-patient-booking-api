package com.rxnow.booking.exception;

public class AppointmentConflictException extends RuntimeException {
    public AppointmentConflictException(String message) {
        super(message);
    }
}
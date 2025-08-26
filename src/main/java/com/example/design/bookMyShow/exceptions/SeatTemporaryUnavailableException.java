package com.example.design.bookMyShow.exceptions;

public class SeatTemporaryUnavailableException extends RuntimeException {
    public SeatTemporaryUnavailableException(String message){
        super(message);
    }
}

package com.example.design.bookMyShow.exceptions;

public class SeatPermanentlyUnavailableException extends RuntimeException {
    public SeatPermanentlyUnavailableException(String message){
        super(message);
    }
}

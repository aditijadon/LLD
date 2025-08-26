package com.example.design.ultimateParkingLot.exception;

public class NoAvailableSpotException extends RuntimeException{
    public NoAvailableSpotException(String message) {
        super(message);
    }
}

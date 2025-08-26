package com.example.design.LLD.parkingLot.exception;

public class SpotNotAvailableException extends RuntimeException{
    public SpotNotAvailableException(String message){
        super(message);
    }
}

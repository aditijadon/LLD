package com.example.design.bookMyShow.exceptions;

public class ScreenAlreadyOccupiedException extends RuntimeException {
    public ScreenAlreadyOccupiedException(String message){
        super(message);
    }
}

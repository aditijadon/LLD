package com.example.design.bookMyShow.exceptions;

public class InvalidStateException extends RuntimeException {
    public InvalidStateException(String message){
        super(message);
    }
}

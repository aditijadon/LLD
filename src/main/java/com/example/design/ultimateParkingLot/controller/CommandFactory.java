package com.example.design.ultimateParkingLot.controller;

import Other.ultimateParkingLot.exception.InvalidInputException;

public interface CommandFactory {
    Command createCommand(String[] tokens) throws InvalidInputException;
}

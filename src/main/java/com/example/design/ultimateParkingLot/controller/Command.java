package com.example.design.ultimateParkingLot.controller;

import Other.ultimateParkingLot.exception.ParkingException;

import java.io.PrintStream;

public interface Command {
    void execute(PrintStream output) throws ParkingException;
}

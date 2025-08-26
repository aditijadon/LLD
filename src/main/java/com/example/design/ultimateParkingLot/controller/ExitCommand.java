package com.example.design.ultimateParkingLot.controller;

import Other.ultimateParkingLot.exception.ParkingException;

import java.io.PrintStream;
import java.util.Objects;

public final class ExitCommand implements Command{
    private final Runnable exitAction;

    public ExitCommand(Runnable exitAction) {
        this.exitAction = Objects.requireNonNull(exitAction, "Exit action cannot be null");
    }

    @Override
    public final void execute(PrintStream output) throws ParkingException {
        output.println("Exiting Parking System.");
        exitAction.run();
    }
}

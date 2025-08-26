package com.example.design.ultimateParkingLot.controller;

import Other.ultimateParkingLot.exception.ParkingException;

import java.io.PrintStream;

public final class HelpCommand implements Command {
    @Override
    public final void execute(PrintStream output) throws ParkingException {
        output.println("Available commands:");
        output.println("  park <license-plate> <vehicle-type>  - Park a vehicle (e.g., park ABC123 CAR)");
        output.println("  unpark <ticket-id>                   - Unpark a vehicle and get fee");
        output.println("  spots <vehicle-type>                 - Check available spots (e.g., spots CAR)");
        output.println("  help                                - Show this help message");
        output.println("  exit                                - Exit the system");
        output.println("Vehicle types: MOTORCYCLE, CAR, TRUCK");
    }
}

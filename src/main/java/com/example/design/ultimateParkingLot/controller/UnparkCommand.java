package com.example.design.ultimateParkingLot.controller;

import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.exception.ParkingException;
import Other.ultimateParkingLot.service.ParkingLot;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.Objects;

public final class UnparkCommand implements Command{
    private final ParkingLot parkingLot;
    private final String ticketId;

    public UnparkCommand(ParkingLot parkingLot, String ticketId) throws InvalidInputException {
        this.parkingLot = Objects.requireNonNull(parkingLot, "Parking lot cannot be null");
        this.ticketId = Objects.requireNonNullElse(ticketId, "").trim();
        if (this.ticketId.isEmpty()) {
            throw new InvalidInputException("Ticket ID cannot be empty");
        }
    }

    @Override
    public final void execute(PrintStream output) throws ParkingException {
        output.println("Executing unpark command for ticket: " + ticketId);
        double fee = parkingLot.unparkVehicle(ticketId, LocalDateTime.now());
        output.println("Parking fee: $" + String.format("%.2f", fee));
    }
}

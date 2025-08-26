package com.example.design.ultimateParkingLot.controller;

import Other.ultimateParkingLot.enums.VehicleType;
import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.exception.ParkingException;
import Other.ultimateParkingLot.model.Ticket;
import Other.ultimateParkingLot.model.Vehicle;
import Other.ultimateParkingLot.service.ParkingLot;

import java.io.PrintStream;
import java.util.Objects;

public final class ParkCommand implements Command{
    private final ParkingLot parkingLot;
    private final String licensePlate;
    private final VehicleType vehicleType;

    public ParkCommand(ParkingLot parkingLot, String licensePlate, String vehicleTypeStr) throws InvalidInputException {
        this.parkingLot = Objects.requireNonNull(parkingLot, "Parking lot cannot be null");
        this.licensePlate = Objects.requireNonNullElse(licensePlate, "").trim();
        this.vehicleType = parseVehicleType(Objects.requireNonNullElse(vehicleTypeStr, "").trim());
    }

    @Override
    public final void execute(PrintStream output) throws ParkingException {
        output.println("Executing park command for license: " + licensePlate);
        Vehicle vehicle = new Vehicle(licensePlate, vehicleType);
        Ticket ticket = parkingLot.parkVehicle(vehicle);
        output.println("Parked vehicle with ticket ID: " + ticket.getTicketId());
    }

    private VehicleType parseVehicleType(String vehicleTypeStr) throws InvalidInputException {
        if (vehicleTypeStr.isEmpty()) {
            throw new InvalidInputException("Vehicle type cannot be empty. Valid types: MOTORCYCLE, CAR, TRUCK");
        }
        try {
            return VehicleType.valueOf(vehicleTypeStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException("Invalid vehicle type: " + vehicleTypeStr + ". Valid types: MOTORCYCLE, CAR, TRUCK");
        }
    }
}

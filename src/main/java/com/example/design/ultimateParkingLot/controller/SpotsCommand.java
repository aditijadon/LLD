package com.example.design.ultimateParkingLot.controller;

import Other.ultimateParkingLot.enums.VehicleType;
import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.exception.ParkingException;
import Other.ultimateParkingLot.service.ParkingLot;

import java.io.PrintStream;
import java.util.Objects;

public final class SpotsCommand implements Command {
    private final ParkingLot parkingLot;
    private final VehicleType vehicleType;
    private final String vehicleTypeStr;

    public SpotsCommand(ParkingLot parkingLot, String vehicleTypeStr) throws InvalidInputException {
        this.parkingLot = Objects.requireNonNull(parkingLot, "Parking lot cannot be null");
        this.vehicleTypeStr = Objects.requireNonNullElse(vehicleTypeStr, "").trim();
        this.vehicleType = parseVehicleType(this.vehicleTypeStr);
    }

    @Override
    public final void execute(PrintStream output) throws ParkingException {
        output.println("Executing spots command for type: " + vehicleTypeStr);
        int availableSpots = parkingLot.getAvailableSpots(vehicleType);
        output.println("Available spots for " + vehicleTypeStr.toLowerCase() + ": " + availableSpots);
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

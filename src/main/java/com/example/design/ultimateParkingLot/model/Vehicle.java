package com.example.design.ultimateParkingLot.model;

import Other.ultimateParkingLot.enums.VehicleType;
import Other.ultimateParkingLot.exception.InvalidInputException;

import java.util.Objects;

public final class Vehicle {
    private final String licensePlate;
    private final VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) throws InvalidInputException {
        this.licensePlate = Objects.requireNonNullElse(licensePlate, "").trim();
        this.type = Objects.requireNonNull(type, "Vehicle type cannot be null");
        if (this.licensePlate.isEmpty()) {
            throw new InvalidInputException("License plate cannot be empty");
        }
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Vehicle{licensePlate='" + licensePlate + "', type=" + type + "}";
    }
}

package com.example.design.ultimateParkingLot.model;

import Other.ultimateParkingLot.enums.VehicleType;
import Other.ultimateParkingLot.exception.InvalidInputException;

import java.util.Objects;

public final class ParkingSpot {
    private final int id;
    private final VehicleType type;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(int id, VehicleType type) throws InvalidInputException {
        if (id <= 0) {
            throw new InvalidInputException("Spot ID must be positive");
        }
        this.id = id;
        this.type = Objects.requireNonNull(type, "Spot type cannot be null");
        this.isOccupied = false;
        this.vehicle = null;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public VehicleType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = Objects.requireNonNull(vehicle, "Vehicle cannot be null");
        this.isOccupied = true;
    }

    public Vehicle unparkVehicle() {
        Vehicle temp = this.vehicle;
        this.vehicle = null;
        this.isOccupied = false;
        return temp;
    }

    @Override
    public String toString() {
        return "ParkingSpot{id=" + id + ", type=" + type + ", isOccupied=" + isOccupied + "}";
    }
}

package com.example.design.ultimateParkingLot.strategy;

import Other.ultimateParkingLot.model.ParkingSpot;
import Other.ultimateParkingLot.model.Vehicle;

import java.util.List;
import java.util.Objects;

import static Other.ultimateParkingLot.enums.VehicleType.*;

public final class FirstFitParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findParkingSpot(Vehicle vehicle, List<ParkingSpot> spots) {
        Objects.requireNonNull(vehicle, "Vehicle cannot be null");
        Objects.requireNonNull(spots, "Spots list cannot be null");
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && canPark(vehicle, spot)) {
                return spot;
            }
        }
        return null;
    }

    private boolean canPark(Vehicle vehicle, ParkingSpot spot) {
        switch (vehicle.getType()) {
            case MOTORCYCLE:
                return true; // Motorcycle can park anywhere
            case CAR:
                return spot.getType() == CAR || spot.getType() == TRUCK;
            case TRUCK:
                return spot.getType() == TRUCK;
            default:
                return false;
        }
    }
}

package com.example.design.ultimateParkingLot.strategy;

import Other.ultimateParkingLot.model.ParkingSpot;
import Other.ultimateParkingLot.model.Vehicle;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(Vehicle vehicle, List<ParkingSpot> spots);
}

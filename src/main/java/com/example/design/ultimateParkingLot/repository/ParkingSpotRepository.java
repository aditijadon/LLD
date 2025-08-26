package com.example.design.ultimateParkingLot.repository;

import Other.ultimateParkingLot.enums.VehicleType;
import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.model.ParkingSpot;

import java.util.List;

public interface ParkingSpotRepository {
    void saveAll(List<ParkingSpot> spots) throws InvalidInputException;
    List<ParkingSpot> findAll();
    List<ParkingSpot> findByType(VehicleType type);
}

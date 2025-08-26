package com.example.design.LLD.parkingLot.strategy;

import LLD.parkingLot.model.AbstractParkingSpot;
import LLD.parkingLot.model.SpotCoordinates;

import java.util.List;

public interface IParkingStrategy {
    SpotCoordinates findSpot(List<AbstractParkingSpot> availableSpots);
}

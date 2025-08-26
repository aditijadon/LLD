package com.example.design.LLD.parkingLot.strategy;

import LLD.parkingLot.model.AbstractParkingSpot;
import LLD.parkingLot.model.SpotCoordinates;

import java.util.List;

public class DefaultParkingStrategy implements IParkingStrategy{

    @Override
    public SpotCoordinates findSpot(List<AbstractParkingSpot> availableSpots) {
        return availableSpots.get(0).getCoordinates();
    }
}

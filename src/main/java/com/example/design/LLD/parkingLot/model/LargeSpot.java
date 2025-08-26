package com.example.design.LLD.parkingLot.model;

import LLD.parkingLot.enums.SpotType;

public class LargeSpot extends AbstractParkingSpot{
    private final SpotType spotType = SpotType.LARGE;

    public LargeSpot(int floor, int row, int col) {
        super(floor, row, col);
    }

    @Override
    public SpotType getSpotType() {
        return spotType;
    }
}

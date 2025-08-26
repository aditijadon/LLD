package com.example.design.LLD.parkingLot.model;

import LLD.parkingLot.enums.SpotType;

public class RegularSpot extends AbstractParkingSpot {
    private final SpotType spotType = SpotType.REGULAR;

    public RegularSpot(int floor, int row, int col) {
        super(floor, row, col);
    }

    @Override
    public SpotType getSpotType() {
        return spotType;
    }
}

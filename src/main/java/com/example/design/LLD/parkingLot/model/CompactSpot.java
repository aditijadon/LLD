package com.example.design.LLD.parkingLot.model;

import LLD.parkingLot.enums.SpotType;

public class CompactSpot extends AbstractParkingSpot {
    private final SpotType spotType = SpotType.COMPACT;

    public CompactSpot(int floor, int row, int col) {
        super(floor, row, col);
    }

    @Override
    public SpotType getSpotType() {
        return spotType;
    }
}

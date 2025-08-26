package com.example.design.LLD.parkingLot.strategy;

import LLD.parkingLot.model.AbstractParkingSpot;
import LLD.parkingLot.model.SpotCoordinates;

import java.util.List;

public class NearestEntryParkingStrategy implements IParkingStrategy{
    @Override
    public SpotCoordinates findSpot(List<AbstractParkingSpot> availableSpots) { // Considering Entry {0,0}
        int row, col, floor, minSum = Integer.MAX_VALUE, minFloor = Integer.MAX_VALUE;
        AbstractParkingSpot spot = null;
        int count = availableSpots.size();
        for(int i=0; i<count; i++){
            row = availableSpots.get(i).getCoordinates().getRow();
            col = availableSpots.get(i).getCoordinates().getCol();
            floor = availableSpots.get(i).getFloorNumber();
            if(floor < minFloor){
                minFloor = floor;
                if(row + col < minSum){
                    minSum = row + col;
                    spot = availableSpots.get(i);
                }
            }
        }
        return spot.getCoordinates();
    }
}

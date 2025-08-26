package com.example.design.LLD.parkingLot.service;

import LLD.parkingLot.exception.InvalidInputDetailsException;
import LLD.parkingLot.model.AbstractParkingSpot;
import LLD.parkingLot.model.Floor;
import LLD.parkingLot.repository.IParkingSpotRepository;
import LLD.parkingLot.repository.ParkingRepository;


public class ParkingLotService implements IParkingLotService {
    private final IParkingSpotRepository repository;

    public ParkingLotService() {
        this.repository = ParkingRepository.getInstance();
    }

    @Override
    public Floor addFloor(int floorNumber) {
        if(repository.findFloorById(floorNumber) != null){
            throw new InvalidInputDetailsException("Floor number: " + floorNumber + " already exists");
        }
        return repository.addFloor(floorNumber);
    }

    @Override
    public Floor removeFloor(int floorNumber) {
        if(repository.findFloorById(floorNumber) == null){
            throw new InvalidInputDetailsException("Floor number: " + floorNumber + " is invalid");
        }
        Floor floor = repository.findFloorById(floorNumber);
        return repository.removeFloor(floor);
    }

    @Override
    public String printParkingLot(int floorNumber) {
        Floor floor = repository.findFloorById(floorNumber);
        if (floor == null) {
            return "Floor " + floorNumber + " not found.";
        }

        StringBuilder result = new StringBuilder();
        result.append("Floor ").append(floorNumber).append(":\n");
        AbstractParkingSpot[][] spots = floor.getSpots();
        for (AbstractParkingSpot[] row : spots) {
            result.append("[");
            for (int j = 0; j < row.length; j++) {
                AbstractParkingSpot spot = row[j];
                char type = spot.getSpotType().toString().charAt(0); // First letter of SpotType
                String symbol = spot.isAvailable() ? "-" : "p";
                result.append(symbol).append("(").append(type).append(")");
                if (j < row.length - 1) {
                    result.append(" ");
                }
            }
            result.append("]\n");
        }
        return result.toString();
    }
}

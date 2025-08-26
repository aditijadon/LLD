package com.example.design.LLD.parkingLot.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<Floor> floors;

    private ParkingLot() {
        this.floors = new ArrayList<>();
    }

    private static class SingletonHelper {
        private static final ParkingLot INSTANCE = new ParkingLot();
    }

    public static ParkingLot getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public List<Floor> getFloors() {
        return this.floors;
    }

    public Floor addFloor(Floor floor) {
        this.floors.add(floor);
        return floor;
    }

    public Floor removeFloor(Floor floor) {
        this.floors.remove(floor);
        return floor;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "floors=" + (floors != null ? floors.size() + " floors" : "none") +
                '}';
    }
}

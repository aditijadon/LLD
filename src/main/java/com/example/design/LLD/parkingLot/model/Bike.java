package com.example.design.LLD.parkingLot.model;

import LLD.parkingLot.enums.VehicleType;

public class Bike implements Vehicle {
    private final VehicleType vehicleSize = VehicleType.BIKE;
    private final String licensePlate;

    public Bike(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleSize;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }
}

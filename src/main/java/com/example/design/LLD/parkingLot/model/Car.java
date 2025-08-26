package com.example.design.LLD.parkingLot.model;

import LLD.parkingLot.enums.VehicleType;

public class Car implements Vehicle {
    private final VehicleType vehicleSize = VehicleType.CAR;
    private final String licensePlate;

    public Car(String licensePlate) {
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

package com.example.design.LLD.parkingLot.model;

import LLD.parkingLot.enums.VehicleType;

public interface Vehicle {
    VehicleType getVehicleType();
    String getLicensePlate();
}

package com.example.design.LLD.parkingLot.strategy;

import LLD.parkingLot.enums.VehicleType;

public interface FeeCalculationStrategy {
    int getAmount(int hours, VehicleType vehicleType);
}

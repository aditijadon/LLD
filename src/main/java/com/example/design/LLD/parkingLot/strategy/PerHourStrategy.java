package com.example.design.LLD.parkingLot.strategy;

import LLD.parkingLot.enums.VehicleType;

public class PerHourStrategy implements FeeCalculationStrategy{
    @Override
    public int getAmount(int hours, VehicleType vehicleType) {
        int amount;

        switch (vehicleType) {
            case BIKE -> {
                amount = hours*30;
                break;
            }
            case CAR -> {
                amount = hours*50;
                break;
            }
            default ->
                amount = 0;
        }
        return amount;
    }
}

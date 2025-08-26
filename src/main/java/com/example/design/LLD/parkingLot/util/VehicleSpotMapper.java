package com.example.design.LLD.parkingLot.util;

import LLD.parkingLot.enums.SpotType;
import LLD.parkingLot.enums.VehicleType;
import LLD.parkingLot.model.Vehicle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VehicleSpotMapper {
    public static List<SpotType> vehicleToSpotMapper(VehicleType vehicleType) {
        return switch (vehicleType) {
            case BIKE -> Arrays.asList(SpotType.COMPACT, SpotType.REGULAR, SpotType.LARGE);
            case CAR -> Arrays.asList(SpotType.REGULAR, SpotType.LARGE);
            case TRUCK -> Collections.singletonList(SpotType.LARGE);
        };
    }

    public static VehicleType spotToVehicleMapper(SpotType spotType) {
        return switch (spotType) {
            case COMPACT -> VehicleType.BIKE;
            case REGULAR -> VehicleType.CAR;
            case LARGE -> VehicleType.TRUCK;
            case HANDICAPPED -> throw new IllegalArgumentException("HANDICAPPED spots not mapped to any vehicle type");
        };
    }
}

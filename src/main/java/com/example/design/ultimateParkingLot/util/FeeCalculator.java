package com.example.design.ultimateParkingLot.util;

import Other.ultimateParkingLot.enums.VehicleType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class FeeCalculator {
    private static final FeeCalculator INSTANCE = new FeeCalculator();
    private final Map<VehicleType, Double> hourlyRates;

    private FeeCalculator() {
        Map<VehicleType, Double> rates = new HashMap<>();
        rates.put(VehicleType.MOTORCYCLE, 2.0);
        rates.put(VehicleType.CAR, 5.0);
        rates.put(VehicleType.TRUCK, 10.0);
        this.hourlyRates = Collections.unmodifiableMap(rates);
    }

    public static FeeCalculator getInstance() {
        return INSTANCE;
    }

    public double getHourlyRate(VehicleType type) {
        return hourlyRates.getOrDefault(Objects.requireNonNull(type, "Vehicle type cannot be null"), 0.0);
    }
}

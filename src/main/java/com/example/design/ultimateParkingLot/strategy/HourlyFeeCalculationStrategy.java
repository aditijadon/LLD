package com.example.design.ultimateParkingLot.strategy;

import Other.ultimateParkingLot.enums.VehicleType;
import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.exception.InvalidTimeException;
import Other.ultimateParkingLot.model.Ticket;
import Other.ultimateParkingLot.util.FeeCalculator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public final class HourlyFeeCalculationStrategy implements FeeCalculationStrategy{
    private final FeeCalculator feeCalculator;

    public HourlyFeeCalculationStrategy(FeeCalculator feeConfig) {
        this.feeCalculator = Objects.requireNonNull(feeConfig, "Fee config cannot be null");
    }

    @Override
    public double calculateFee(Ticket ticket, LocalDateTime exitTime) throws InvalidInputException, InvalidTimeException {
        Objects.requireNonNull(ticket, "Ticket cannot be null");
        Objects.requireNonNull(exitTime, "Exit time cannot be null");
        if (exitTime.isBefore(ticket.getEntryTime())) {
            throw new InvalidTimeException("Exit time cannot be before entry time");
        }
        VehicleType vehicleType = ticket.getVehicle().getType();
        double rate = feeCalculator.getHourlyRate(vehicleType);
        if (rate == 0.0) {
            throw new InvalidInputException("No rate defined for vehicle type: " + vehicleType);
        }
        Duration duration = Duration.between(ticket.getEntryTime(), exitTime);
        long hours = Math.max(1, duration.toHours()); // Minimum 1 hour
        return hours * rate;
    }
}

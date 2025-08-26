package com.example.design.ultimateParkingLot.strategy;

import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.exception.InvalidTimeException;
import Other.ultimateParkingLot.model.Ticket;

import java.time.LocalDateTime;

public interface FeeCalculationStrategy {
    double calculateFee(Ticket ticket, LocalDateTime exitTime) throws InvalidInputException, InvalidTimeException;
}

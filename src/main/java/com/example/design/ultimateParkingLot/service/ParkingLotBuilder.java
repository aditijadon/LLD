package com.example.design.ultimateParkingLot.service;

import Other.ultimateParkingLot.enums.VehicleType;
import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.factory.TicketFactory;
import Other.ultimateParkingLot.model.ParkingSpot;
import Other.ultimateParkingLot.repository.ParkingSpotRepository;
import Other.ultimateParkingLot.repository.TicketRepository;
import Other.ultimateParkingLot.strategy.FeeCalculationStrategy;
import Other.ultimateParkingLot.strategy.ParkingStrategy;

import java.util.*;

public final class ParkingLotBuilder {
    private final Map<VehicleType, Integer> spotCounts;
    private ParkingStrategy parkingStrategy;
    private FeeCalculationStrategy feeCalculationStrategy;
    private TicketFactory ticketFactory;
    private ParkingSpotRepository parkingSpotRepository;
    private TicketRepository ticketRepository;

    public ParkingLotBuilder() {
        this.spotCounts = new HashMap<>();
    }

    public ParkingLotBuilder addSpots(VehicleType type, int count) throws InvalidInputException {
        Objects.requireNonNull(type, "Vehicle type cannot be null");
        if (count < 0) {
            throw new InvalidInputException("Spot count cannot be negative");
        }
        spotCounts.put(type, spotCounts.getOrDefault(type, 0) + count);
        return this;
    }

    public ParkingLotBuilder withParkingStrategy(ParkingStrategy strategy) throws InvalidInputException {
        this.parkingStrategy = Objects.requireNonNull(strategy, "Parking strategy cannot be null");
        return this;
    }

    public ParkingLotBuilder withFeeCalculationStrategy(FeeCalculationStrategy strategy) throws InvalidInputException {
        this.feeCalculationStrategy = Objects.requireNonNull(strategy, "Fee calculation strategy cannot be null");
        return this;
    }

    public ParkingLotBuilder withTicketFactory(TicketFactory factory) throws InvalidInputException {
        this.ticketFactory = Objects.requireNonNull(factory, "Ticket factory cannot be null");
        return this;
    }

    public ParkingLotBuilder withParkingSpotRepository(ParkingSpotRepository repository) throws InvalidInputException {
        this.parkingSpotRepository = Objects.requireNonNull(repository, "Parking spot repository cannot be null");
        return this;
    }

    public ParkingLotBuilder withTicketRepository(TicketRepository repository) throws InvalidInputException {
        this.ticketRepository = Objects.requireNonNull(repository, "Ticket repository cannot be null");
        return this;
    }

    public ParkingLot build() throws InvalidInputException {
        if (spotCounts.isEmpty() || spotCounts.values().stream().allMatch(count -> count == 0)) {
            throw new InvalidInputException("At least one spot must be defined");
        }
        if (parkingStrategy == null || feeCalculationStrategy == null || ticketFactory == null ||
                parkingSpotRepository == null || ticketRepository == null) {
            throw new InvalidInputException("All strategies, factory, and repositories must be set");
        }
        List<ParkingSpot> spots = new ArrayList<>();
        int id = 1;
        for (Map.Entry<VehicleType, Integer> entry : spotCounts.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                spots.add(new ParkingSpot(id++, entry.getKey()));
            }
        }
        System.out.println("Building parking lot with " + spots.size() + " spots");
        parkingSpotRepository.saveAll(spots);
        return new ParkingLot(parkingSpotRepository, ticketRepository, parkingStrategy, feeCalculationStrategy, ticketFactory);
    }
}

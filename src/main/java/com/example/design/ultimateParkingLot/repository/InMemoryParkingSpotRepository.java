package com.example.design.ultimateParkingLot.repository;

import Other.ultimateParkingLot.enums.VehicleType;
import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.model.ParkingSpot;

import java.util.*;

public final class InMemoryParkingSpotRepository implements ParkingSpotRepository {
    private final Map<Integer, ParkingSpot> spots;
    private final Map<VehicleType, List<ParkingSpot>> spotsByType;

    public InMemoryParkingSpotRepository() {
        this.spots = new HashMap<>();
        this.spotsByType = new EnumMap<>(VehicleType.class);
        for (VehicleType type : VehicleType.values()) {
            spotsByType.put(type, new ArrayList<>());
        }
    }

    @Override
    public void saveAll(List<ParkingSpot> spots) throws InvalidInputException {
        Objects.requireNonNull(spots, "Spot list cannot be null");
        System.out.println("Saving " + spots.size() + " parking spots");
        for (ParkingSpot spot : spots) {
            if (spot == null) {
                throw new InvalidInputException("Individual spot cannot be null");
            }
            this.spots.put(spot.getId(), spot);
            this.spotsByType.get(spot.getType()).add(spot);
        }
    }

    @Override
    public List<ParkingSpot> findAll() {
        System.out.println("Retrieving all parking spots");
        return Collections.unmodifiableList(new ArrayList<>(spots.values()));
    }

    @Override
    public List<ParkingSpot> findByType(VehicleType type) {
        Objects.requireNonNull(type, "Vehicle type cannot be null");
        System.out.println("Retrieving spots for type: " + type);
        return Collections.unmodifiableList(new ArrayList<>(spotsByType.getOrDefault(type, Collections.emptyList())));
    }
}

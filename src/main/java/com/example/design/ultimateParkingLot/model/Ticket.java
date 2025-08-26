package com.example.design.ultimateParkingLot.model;

import Other.ultimateParkingLot.exception.InvalidInputException;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot, LocalDateTime entryTime) throws InvalidInputException {
        this.ticketId = Objects.requireNonNullElse(ticketId, "").trim();
        this.vehicle = Objects.requireNonNull(vehicle, "Vehicle cannot be null");
        this.spot = Objects.requireNonNull(spot, "Spot cannot be null");
        this.entryTime = Objects.requireNonNull(entryTime, "Entry time cannot be null");
        if (this.ticketId.isEmpty()) {
            throw new InvalidInputException("Ticket ID cannot be empty");
        }
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    @Override
    public String toString() {
        return "Ticket{ticketId='" + ticketId + "', vehicle=" + vehicle + ", spot=" + spot + ", entryTime=" + entryTime + "}";
    }
}

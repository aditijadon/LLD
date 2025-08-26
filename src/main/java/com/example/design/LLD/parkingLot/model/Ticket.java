package com.example.design.LLD.parkingLot.model;

import LLD.parkingLot.enums.SpotType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final SpotCoordinates coordinates;
    private final String licensePlate;
    private final LocalDateTime entryTime;
    private final int floor;
    private final SpotType spotType;

    public Ticket(SpotCoordinates coordinates, String licensePlate, int floor, SpotType spotType) {
        this.ticketId = UUID.randomUUID().toString();
        this.coordinates = coordinates;
        this.licensePlate = licensePlate;
        this.entryTime = LocalDateTime.now();
        this.floor = floor;
        this.spotType = spotType;
    }

    public String getTicketId() {
        return ticketId;
    }

    public SpotCoordinates getCoordinates() {
        return coordinates;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", coordinates=" + (coordinates != null ? coordinates : "none") +
                ", licensePlate='" + licensePlate + '\'' +
                ", entryTime=" + entryTime +
                ", floor=" + floor +
                ", spotType=" + spotType +
                '}';
    }
}

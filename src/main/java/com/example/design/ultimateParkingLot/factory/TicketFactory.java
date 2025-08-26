package com.example.design.ultimateParkingLot.factory;

import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.model.ParkingSpot;
import Other.ultimateParkingLot.model.Ticket;
import Other.ultimateParkingLot.model.Vehicle;

import java.time.LocalDateTime;
import java.util.Objects;

public final class TicketFactory {
    public Ticket createTicket(Vehicle vehicle, ParkingSpot spot) throws InvalidInputException {
        Objects.requireNonNull(vehicle, "Vehicle cannot be null");
        Objects.requireNonNull(spot, "Spot cannot be null");
        String ticketId = "TICKET-" + vehicle.getLicensePlate() + "-" + System.currentTimeMillis();
        return new Ticket(ticketId, vehicle, spot, LocalDateTime.now());
    }
}

package com.example.design.ultimateParkingLot.service;

import Other.ultimateParkingLot.enums.VehicleType;
import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.exception.InvalidTicketException;
import Other.ultimateParkingLot.exception.InvalidTimeException;
import Other.ultimateParkingLot.exception.NoAvailableSpotException;
import Other.ultimateParkingLot.factory.TicketFactory;
import Other.ultimateParkingLot.model.ParkingSpot;
import Other.ultimateParkingLot.model.Ticket;
import Other.ultimateParkingLot.model.Vehicle;
import Other.ultimateParkingLot.repository.ParkingSpotRepository;
import Other.ultimateParkingLot.repository.TicketRepository;
import Other.ultimateParkingLot.strategy.FeeCalculationStrategy;
import Other.ultimateParkingLot.strategy.ParkingStrategy;

import java.time.LocalDateTime;
import java.util.Objects;

public final class ParkingLot {
    private final ParkingSpotRepository parkingSpotRepository;
    private final TicketRepository ticketRepository;
    private final ParkingStrategy parkingStrategy;
    private final FeeCalculationStrategy feeCalculationStrategy;
    private final TicketFactory ticketFactory;

    public ParkingLot(ParkingSpotRepository parkingSpotRepository, TicketRepository ticketRepository,
                      ParkingStrategy parkingStrategy, FeeCalculationStrategy feeCalculationStrategy,
                      TicketFactory ticketFactory) {
        this.parkingSpotRepository = Objects.requireNonNull(parkingSpotRepository, "Parking spot repository cannot be null");
        this.ticketRepository = Objects.requireNonNull(ticketRepository, "Ticket repository cannot be null");
        this.parkingStrategy = Objects.requireNonNull(parkingStrategy, "Parking strategy cannot be null");
        this.feeCalculationStrategy = Objects.requireNonNull(feeCalculationStrategy, "Fee calculation strategy cannot be null");
        this.ticketFactory = Objects.requireNonNull(ticketFactory, "Ticket factory cannot be null");
    }

    public Ticket parkVehicle(Vehicle vehicle) throws InvalidInputException, NoAvailableSpotException {
        Objects.requireNonNull(vehicle, "Vehicle cannot be null");
        System.out.println("Parking vehicle: " + vehicle);
        ParkingSpot spot = parkingStrategy.findParkingSpot(vehicle, parkingSpotRepository.findAll());
        if (spot == null) {
            throw new NoAvailableSpotException("No available spot for vehicle type: " + vehicle.getType());
        }
        spot.parkVehicle(vehicle);
        Ticket ticket = ticketFactory.createTicket(vehicle, spot);
        ticketRepository.save(ticket);
        return ticket;
    }

    public double unparkVehicle(String ticketId, LocalDateTime exitTime) throws InvalidTicketException, InvalidInputException, InvalidTimeException {
        Objects.requireNonNull(ticketId, "Ticket ID cannot be null");
        if (ticketId.trim().isEmpty()) {
            throw new InvalidInputException("Ticket ID cannot be empty");
        }
        System.out.println("Unparking vehicle with ticket: " + ticketId);
        Ticket ticket = ticketRepository.findById(ticketId);
        ticket.getSpot().unparkVehicle();
        ticketRepository.delete(ticketId);
        return feeCalculationStrategy.calculateFee(ticket, exitTime);
    }

    public int getAvailableSpots(VehicleType type) throws InvalidInputException {
        Objects.requireNonNull(type, "Vehicle type cannot be null");
        System.out.println("Checking available spots for type: " + type);
        int count = 0;
        for (ParkingSpot spot : parkingSpotRepository.findByType(VehicleType.TRUCK)) {
            if (!spot.isOccupied() && (type == VehicleType.TRUCK || type == VehicleType.CAR || type == VehicleType.MOTORCYCLE)) {
                count++;
            }
        }
        if (type == VehicleType.CAR || type == VehicleType.MOTORCYCLE) {
            for (ParkingSpot spot : parkingSpotRepository.findByType(VehicleType.CAR)) {
                if (!spot.isOccupied()) {
                    count++;
                }
            }
        }
        if (type == VehicleType.MOTORCYCLE) {
            for (ParkingSpot spot : parkingSpotRepository.findByType(VehicleType.MOTORCYCLE)) {
                if (!spot.isOccupied()) {
                    count++;
                }
            }
        }
        return count;
    }
}

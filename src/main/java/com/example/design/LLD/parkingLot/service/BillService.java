package com.example.design.LLD.parkingLot.service;


import LLD.parkingLot.model.AbstractParkingSpot;
import LLD.parkingLot.model.Bill;
import LLD.parkingLot.model.Ticket;
import LLD.parkingLot.model.Vehicle;
import LLD.parkingLot.repository.IParkingSpotRepository;
import LLD.parkingLot.repository.ParkingRepository;
import LLD.parkingLot.strategy.FeeCalculationStrategy;
import LLD.parkingLot.strategy.PerHourStrategy;

import java.time.Duration;
import java.time.LocalDateTime;


public class BillService implements IBillService{
    private final IParkingSpotRepository repository;
    private final FeeCalculationStrategy feeCalculationStrategy;

    public BillService() {
        this.repository = ParkingRepository.getInstance();
        feeCalculationStrategy = new PerHourStrategy();
    }

    @Override
    public Bill generateBill(String ticketId) {
        if (ticketId == null || ticketId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid ticket ID");
        }
        Ticket ticket = repository.getTicketById(ticketId);
        if (ticket == null) {
            throw new IllegalStateException("Ticket: " + ticketId + " is invalid.");
        }
        Vehicle vehicle = repository.getVehicleByLicensePlate(ticket.getLicensePlate());
        AbstractParkingSpot spot = repository.getSpotByCoordinates(ticket.getCoordinates());
        Duration duration  = Duration.between(ticket.getEntryTime(), LocalDateTime.now());
        int amount = feeCalculationStrategy.getAmount((int) duration.toHours(), vehicle.getVehicleType());
        return repository.unPark(ticket, spot, vehicle, amount);
    }
}

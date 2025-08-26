package com.example.design.LLD.parkingLot.facade;

import LLD.parkingLot.model.Ticket;
import LLD.parkingLot.model.Vehicle;
import LLD.parkingLot.service.ITicketService;
import LLD.parkingLot.service.TicketService;
import LLD.parkingLot.strategy.DefaultParkingStrategy;
import LLD.parkingLot.strategy.IParkingStrategy;


public class TicketGenerator {
    private final ITicketService ticketService;

    public TicketGenerator() {
        this.ticketService = new TicketService();
    }

    public Ticket generateTicket(Vehicle vehicle) {
        return ticketService.generateTicket(vehicle, new DefaultParkingStrategy());
    }

    public Ticket generateTicket(Vehicle vehicle, IParkingStrategy parkingStrategy) {
        return ticketService.generateTicket(vehicle, parkingStrategy);
    }
}

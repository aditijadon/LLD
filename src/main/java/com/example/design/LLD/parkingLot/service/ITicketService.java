package com.example.design.LLD.parkingLot.service;

import LLD.parkingLot.model.Ticket;
import LLD.parkingLot.model.Vehicle;
import LLD.parkingLot.strategy.IParkingStrategy;

public interface ITicketService {
    Ticket generateTicket(Vehicle vehicle, IParkingStrategy parkingStrategy);
}

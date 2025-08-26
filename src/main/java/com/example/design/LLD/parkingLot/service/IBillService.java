package com.example.design.LLD.parkingLot.service;

import LLD.parkingLot.model.Bill;
import LLD.parkingLot.model.Ticket;
import LLD.parkingLot.model.Vehicle;

public interface IBillService {
    Bill generateBill(String ticketId);
}

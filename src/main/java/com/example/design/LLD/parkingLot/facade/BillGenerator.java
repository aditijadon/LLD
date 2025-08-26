package com.example.design.LLD.parkingLot.facade;

import LLD.parkingLot.model.Bill;
import LLD.parkingLot.service.BillService;
import LLD.parkingLot.service.IBillService;

public class BillGenerator {
    private final IBillService billService;

    public BillGenerator() {
        this.billService = new BillService();
    }

    public Bill generateBill(String ticketId) {
        return billService.generateBill(ticketId);
    }
}
package com.example.design.LLD.parkingLot.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Bill {
    private final String billId;
    private final int amount;
    private final LocalDateTime exitTime;

    public Bill(int amount){
        this.billId = UUID.randomUUID().toString();
        this.amount = amount;
        this.exitTime = LocalDateTime.now();
    }

    public String getBillId() {
        return billId;
    }

    public int getAmount() {
        return amount;
    }
}

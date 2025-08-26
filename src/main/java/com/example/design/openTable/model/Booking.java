package com.example.design.openTable.model;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final String id;
    private final Customer customer;
    private final List<Table> tables;
    private final LocalDateTime bookingTime;

    public Booking(@NonNull final String id, @NonNull final Customer customer, @NonNull LocalDateTime bookingTime){
        this.id = id;
        this.customer = customer;
        this.tables = new ArrayList<>();
        this.bookingTime = bookingTime;
    }
}

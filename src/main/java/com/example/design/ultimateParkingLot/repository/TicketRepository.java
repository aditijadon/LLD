package com.example.design.ultimateParkingLot.repository;

import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.exception.InvalidTicketException;
import Other.ultimateParkingLot.model.Ticket;

public interface TicketRepository {
    void save(Ticket ticket) throws InvalidInputException;
    Ticket findById(String ticketId) throws InvalidTicketException;
    void delete(String ticketId) throws InvalidTicketException;
}

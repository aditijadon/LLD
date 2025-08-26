package com.example.design.ultimateParkingLot.repository;

import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.exception.InvalidTicketException;
import Other.ultimateParkingLot.model.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class InMemoryTicketRepository implements TicketRepository{
    private final Map<String, Ticket> tickets;

    public InMemoryTicketRepository() {
        this.tickets = new HashMap<>();
    }

    @Override
    public void save(Ticket ticket) throws InvalidInputException {
        Objects.requireNonNull(ticket, "Ticket cannot be null");
        if (ticket.getTicketId() == null || ticket.getTicketId().isEmpty()) {
            throw new InvalidInputException("Ticket ID cannot be null or empty");
        }
        System.out.println("Saving ticket: " + ticket.getTicketId());
        tickets.put(ticket.getTicketId(), ticket);
    }

    @Override
    public Ticket findById(String ticketId) throws InvalidTicketException {
        Objects.requireNonNull(ticketId, "Ticket ID cannot be null");
        if (ticketId.trim().isEmpty()) {
            throw new InvalidTicketException("Ticket ID cannot be empty");
        }
        System.out.println("Retrieving ticket: " + ticketId);
        Ticket ticket = tickets.get(ticketId);
        if (ticket == null) {
            throw new InvalidTicketException("Invalid ticket ID: " + ticketId);
        }
        return ticket;
    }

    @Override
    public void delete(String ticketId) throws InvalidTicketException {
        Objects.requireNonNull(ticketId, "Ticket ID cannot be null");
        if (ticketId.trim().isEmpty()) {
            throw new InvalidTicketException("Ticket ID cannot be empty");
        }
        System.out.println("Deleting ticket: " + ticketId);
        if (!tickets.containsKey(ticketId)) {
            throw new InvalidTicketException("Invalid ticket ID: " + ticketId);
        }
        tickets.remove(ticketId);
    }
}

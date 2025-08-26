package com.example.design.LLD.parkingLot.service;

import LLD.parkingLot.enums.SpotType;
import LLD.parkingLot.enums.VehicleType;
import LLD.parkingLot.exception.InvalidInputDetailsException;
import LLD.parkingLot.model.AbstractParkingSpot;
import LLD.parkingLot.model.SpotCoordinates;
import LLD.parkingLot.model.Ticket;
import LLD.parkingLot.model.Vehicle;
import LLD.parkingLot.repository.IParkingSpotRepository;
import LLD.parkingLot.repository.ParkingRepository;
import LLD.parkingLot.strategy.IParkingStrategy;
import LLD.parkingLot.util.VehicleSpotMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TicketService implements ITicketService{
    private final IParkingSpotRepository repository;

    public TicketService() {
        this.repository = ParkingRepository.getInstance();
    }

    @Override
    public Ticket generateTicket(Vehicle vehicle, IParkingStrategy parkingStrategy) {
        validate(vehicle);
        Ticket ticket = null;
        VehicleType vehicleType = vehicle.getVehicleType();
        List<SpotType> compatibleSpotTypes = VehicleSpotMapper.vehicleToSpotMapper(vehicleType);
        for (SpotType spotType : compatibleSpotTypes) {
            List<AbstractParkingSpot> availableSpots = repository.getAvailableSpotsBySpotType(spotType);
            if (!availableSpots.isEmpty()) {
                SpotCoordinates coordinates = parkingStrategy.findSpot(availableSpots);
                AbstractParkingSpot spot = repository.getSpotByCoordinates(coordinates);
                ticket = repository.park(spot, vehicle);
                break;
            }
        }
        return ticket;
    }

    void validate(Vehicle vehicle){
        if(vehicle == null || vehicle.getLicensePlate().trim().isEmpty() || vehicle.getLicensePlate() == null)
            throw new InvalidInputDetailsException("Vehicle details are invalid.");
    }
}

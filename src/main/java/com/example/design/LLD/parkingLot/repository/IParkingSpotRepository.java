package com.example.design.LLD.parkingLot.repository;

import LLD.parkingLot.enums.SpotType;
import LLD.parkingLot.model.*;

import java.util.List;


public interface IParkingSpotRepository {
    Ticket park(AbstractParkingSpot spot, Vehicle vehicle);
    Bill unPark(Ticket ticket, AbstractParkingSpot spot, Vehicle vehicle, int amount);
    Floor addFloor(int floorNum);
    Floor removeFloor(Floor floor);
    Floor findFloorById(int floorNum);
    List<AbstractParkingSpot> getAvailableSpotsBySpotType(SpotType spotType);
    Ticket getTicketById(String ticketId);
    Vehicle getVehicleByLicensePlate(String licensePlate);
    AbstractParkingSpot getSpotByCoordinates(SpotCoordinates coordinates);
}

package com.example.design.LLD.parkingLot.repository;

import LLD.parkingLot.enums.SpotType;
import LLD.parkingLot.model.*;
import java.util.*;
import java.util.stream.Collectors;


public class ParkingRepository implements IParkingSpotRepository {
    private final ParkingLot parkingLot;
    private final int floorLength;
    private final int floorWidth;
    private final List<Vehicle> vehicles;
    private final List<Ticket> activeTickets;

    private ParkingRepository() {
        this.parkingLot = ParkingLot.getInstance();
        this.floorLength = 4;
        this.floorWidth = 4;
        this.vehicles = new ArrayList<>();
        this.activeTickets = new ArrayList<>();
    }

    private static class SingletonHelper {
        private static final ParkingRepository INSTANCE = new ParkingRepository();
    }

    public static ParkingRepository getInstance() {
            return SingletonHelper.INSTANCE;
    }

    @Override
    public Floor addFloor(int floorNum) {
        Floor floor = new Floor(floorNum, floorLength, floorWidth);
        return parkingLot.addFloor(floor);
    }

    @Override
    public Floor removeFloor(Floor floor) {
        return parkingLot.removeFloor(floor);
    }

    @Override
    public Floor findFloorById(int floorNum){
        return parkingLot.getFloors().stream().filter(f -> f.getId() == floorNum).findAny().orElse(null);
    }

    @Override
    public Ticket park(AbstractParkingSpot spot, Vehicle vehicle) {
        spot.setVehicle(vehicle);
        spot.setAvailable(false);
        vehicles.add(vehicle);
        Ticket ticket = new Ticket(spot.getCoordinates(), vehicle.getLicensePlate(), spot.getFloorNumber(), spot.getSpotType());
        activeTickets.add(ticket);
        return ticket;
    }

    @Override
    public Bill unPark(Ticket ticket, AbstractParkingSpot spot, Vehicle vehicle, int amount) {
        spot.setAvailable(true);
        spot.setVehicle(null);
        vehicles.remove(vehicle);
        activeTickets.remove(ticket);
        Bill bill = new Bill(amount);
        return bill;
    }

    @Override
    public Vehicle getVehicleByLicensePlate(String licensePlate){
        return vehicles.stream().filter(vehicle -> vehicle.getLicensePlate().equals(licensePlate)).findAny().orElse(null);
    }

    @Override
    public AbstractParkingSpot getSpotByCoordinates(SpotCoordinates coordinates){
        return parkingLot.getFloors().stream()
                .flatMap(floor -> Arrays.stream(floor.getSpots()))
                .flatMap(floor -> Arrays.stream(floor))
                .filter(spot -> spot.getCoordinates().getRow() == coordinates.getRow() && spot.getCoordinates().getCol() == coordinates.getCol())
                .findAny().orElse(null);
    }

    @Override
    public List<AbstractParkingSpot> getAvailableSpotsBySpotType(SpotType spotType) {
        return Collections.unmodifiableList(
                parkingLot.getFloors().stream()
                        .flatMap(floor -> Arrays.stream(floor.getSpots()))
                        .flatMap(floor -> Arrays.stream(floor))
                        .filter(spot -> spot.isAvailable() && spot.getSpotType().equals(spotType))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Ticket getTicketById(String ticketId) {
        return activeTickets.stream().filter(ticket -> ticket.getTicketId() == ticketId).findAny().orElse(null);
    }
}

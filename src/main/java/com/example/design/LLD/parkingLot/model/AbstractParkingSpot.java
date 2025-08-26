package com.example.design.LLD.parkingLot.model;

import LLD.parkingLot.enums.SpotType;

public abstract class AbstractParkingSpot{
    private SpotCoordinates coordinates;
    private final int floorNumber;
    private boolean isAvailable;
    private Vehicle vehicle;

    protected AbstractParkingSpot(int floor, int row, int col) {
        this.floorNumber = floor;
        this.isAvailable = true;
        this.vehicle = null;
        this.coordinates = new SpotCoordinates(row, col);
    }

    public SpotCoordinates getCoordinates() {
        return coordinates;
    }

    public abstract SpotType getSpotType();      // Making it abstract

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "AbstractParkingSpot{" +
                "coordinates=" + (coordinates != null ? coordinates : "none") +
                ", floor=" + floorNumber +
                ", isAvailable=" + isAvailable +
                ", vehicle=" + (vehicle != null ? "Vehicle[type=" + vehicle.getVehicleType() + ", licensePlate=" + vehicle.getLicensePlate() + "]" : "none") +
                ", spotType=" + getSpotType() +
                '}';
    }
}
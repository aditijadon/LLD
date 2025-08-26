package com.example.design.LLD.parkingLot.facade;

import LLD.parkingLot.model.Floor;
import LLD.parkingLot.service.IParkingLotService;
import LLD.parkingLot.service.ParkingLotService;


public class ParkingLotManager {
    private final IParkingLotService parkingLotService;

    public ParkingLotManager(){
        this.parkingLotService = new ParkingLotService();
    }

    public Floor addFloor(int floorNumber){
        return parkingLotService.addFloor(floorNumber);
    }

    public Floor removeFloor(int floorNumber){
        return parkingLotService.removeFloor(floorNumber);
    }

    public void printParkingLot(int floorNumber){
        System.out.println(parkingLotService.printParkingLot(floorNumber));
    }

}

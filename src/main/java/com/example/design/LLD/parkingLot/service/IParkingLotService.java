package com.example.design.LLD.parkingLot.service;

import LLD.parkingLot.model.Floor;


public interface IParkingLotService {
    Floor addFloor(int floorNumber);
    Floor removeFloor(int floorNumber);
    String printParkingLot(int floorNumber);
}

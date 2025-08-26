package com.example.design.LLD.parkingLot;

import LLD.parkingLot.facade.BillGenerator;
import LLD.parkingLot.facade.ParkingLotManager;
import LLD.parkingLot.facade.TicketGenerator;
import LLD.parkingLot.model.Bike;
import LLD.parkingLot.model.Car;
import LLD.parkingLot.model.Ticket;
import LLD.parkingLot.model.Vehicle;
import LLD.parkingLot.strategy.NearestEntryParkingStrategy;

public class Main {
    public static void main(String[] args) {
        ParkingLotManager parkingLotManager = new ParkingLotManager();;
        parkingLotManager.addFloor(0);
        parkingLotManager.printParkingLot(0);
        parkingLotManager.printParkingLot(1);
//        parkingLotManager.addFloor(1);
//        parkingLotManager.addFloor(2);
//        parkingLotManager.addFloor(3);
//        parkingLotManager.removeFloor();

        Vehicle vehicle1 = new Bike("KA0385");
        Vehicle vehicle2 = new Car("KA0385");
        Vehicle vehicle3 = new Car("KA0885");
        Vehicle vehicle4 = new Car("KA0995");
        Vehicle vehicle5 = new Car("KA6685");
        Vehicle vehicle6 = new Car("KA0335");

        TicketGenerator ticketGenerator = new TicketGenerator();
//        Ticket t1 = ticketGenerator.generateTicket(vehicle1);
//        parkingLotManager.printParkingLot(0);
//        Ticket t2 = ticketGenerator.generateTicket(vehicle2);
//        parkingLotManager.printParkingLot(0);
//        Ticket t3 = ticketGenerator.generateTicket(vehicle3);
//        parkingLotManager.printParkingLot(0);
//        Ticket t4 = ticketGenerator.generateTicket(vehicle4);
//        parkingLotManager.printParkingLot(0);
//        Ticket t5 = ticketGenerator.generateTicket(vehicle5);
//        parkingLotManager.printParkingLot(0);
//        Ticket t6 = ticketGenerator.generateTicket(vehicle6);
//        parkingLotManager.printParkingLot(0);

        Ticket t1 = ticketGenerator.generateTicket(vehicle1, new NearestEntryParkingStrategy());
        parkingLotManager.printParkingLot(0);
        Ticket t2 = ticketGenerator.generateTicket(vehicle2, new NearestEntryParkingStrategy());
        parkingLotManager.printParkingLot(0);
        Ticket t3 = ticketGenerator.generateTicket(vehicle3, new NearestEntryParkingStrategy());
        parkingLotManager.printParkingLot(0);
        Ticket t4 = ticketGenerator.generateTicket(vehicle4, new NearestEntryParkingStrategy());
        parkingLotManager.printParkingLot(0);
        Ticket t5 = ticketGenerator.generateTicket(vehicle5, new NearestEntryParkingStrategy());
        parkingLotManager.printParkingLot(0);
        Ticket t6 = ticketGenerator.generateTicket(vehicle6, new NearestEntryParkingStrategy());
        parkingLotManager.printParkingLot(0);


//        BillGenerator billGenerator = new BillGenerator();
//        billGenerator.generateBill(t1.getTicketId());
//        parkingLotManager.printParkingLot(0);
//
//        billGenerator.generateBill(t2.getTicketId());
//        parkingLotManager.printParkingLot(0);
//
//        billGenerator.generateBill(t3.getTicketId());
//        parkingLotManager.printParkingLot(0);
//
//        billGenerator.generateBill(t4.getTicketId());
//        parkingLotManager.printParkingLot(0);
//
//        billGenerator.generateBill(t5.getTicketId());
//        parkingLotManager.printParkingLot(0);





//        billGenerator.generateBill(t4.getTicketId());
//        billGenerator.generateBill(t5.getTicketId());
//        billGenerator.generateBill(t6.getTicketId());
    }
}

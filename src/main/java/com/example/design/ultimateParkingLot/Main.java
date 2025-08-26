package com.example.design.ultimateParkingLot;

import Other.ultimateParkingLot.controller.CommandProcessor;
import Other.ultimateParkingLot.enums.VehicleType;
import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.factory.TicketFactory;
import Other.ultimateParkingLot.repository.InMemoryParkingSpotRepository;
import Other.ultimateParkingLot.repository.InMemoryTicketRepository;
import Other.ultimateParkingLot.service.ParkingLot;
import Other.ultimateParkingLot.service.ParkingLotBuilder;
import Other.ultimateParkingLot.strategy.FirstFitParkingStrategy;
import Other.ultimateParkingLot.strategy.HourlyFeeCalculationStrategy;
import Other.ultimateParkingLot.util.FeeCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize parking lot
            ParkingLot parkingLot = new ParkingLotBuilder()
                    .addSpots(VehicleType.MOTORCYCLE, 2)
                    .addSpots(VehicleType.CAR, 3)
                    .addSpots(VehicleType.TRUCK, 1)
                    .withParkingStrategy(new FirstFitParkingStrategy())
                    .withFeeCalculationStrategy(new HourlyFeeCalculationStrategy(FeeCalculator.getInstance()))
                    .withTicketFactory(new TicketFactory())
                    .withParkingSpotRepository(new InMemoryParkingSpotRepository())
                    .withTicketRepository(new InMemoryTicketRepository())
                    .build();

            // Initialize command processor with console input
            CommandProcessor processor = new CommandProcessor(parkingLot, new Scanner(System.in), System.out);

            // Start CLI
            System.out.println("Starting Parking System...");
            processor.start();

        } catch (InvalidInputException e) {
            System.err.println("Initialization error: " + e.getMessage());
        }
    }
}

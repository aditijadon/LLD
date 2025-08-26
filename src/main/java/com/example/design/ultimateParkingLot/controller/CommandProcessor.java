package com.example.design.ultimateParkingLot.controller;

import Other.ultimateParkingLot.exception.InvalidInputException;
import Other.ultimateParkingLot.exception.ParkingException;
import Other.ultimateParkingLot.service.ParkingLot;

import java.io.PrintStream;
import java.util.*;

public final class CommandProcessor {
    private final ParkingLot parkingLot;
    private final Scanner scanner;
    private final PrintStream output;
    private final Map<String, CommandFactory> commandFactories;
    private boolean running;

    public CommandProcessor(ParkingLot parkingLot, Scanner scanner, PrintStream output) throws InvalidInputException {
        this.parkingLot = Objects.requireNonNull(parkingLot, "Parking lot cannot be null");
        this.scanner = Objects.requireNonNull(scanner, "Scanner cannot be null");
        this.output = Objects.requireNonNull(output, "Output stream cannot be null");
        this.running = false;
        this.commandFactories = initializeCommandFactories();
    }

    private Map<String, CommandFactory> initializeCommandFactories() {
        Map<String, CommandFactory> factories = new HashMap<>();
        factories.put("park", tokens -> {
            if (tokens.length != 3) {
                throw new InvalidInputException("Usage: park <license-plate> <vehicle-type>");
            }
            return new ParkCommand(parkingLot, tokens[1], tokens[2]);
        });
        factories.put("unpark", tokens -> {
            if (tokens.length != 2) {
                throw new InvalidInputException("Usage: unpark <ticket-id>");
            }
            return new UnparkCommand(parkingLot, tokens[1]);
        });
        factories.put("spots", tokens -> {
            if (tokens.length != 2) {
                throw new InvalidInputException("Usage: spots <vehicle-type>");
            }
            return new SpotsCommand(parkingLot, tokens[1]);
        });
        factories.put("help", tokens -> new HelpCommand());
        factories.put("exit", tokens -> new ExitCommand(() -> running = false));
        return Collections.unmodifiableMap(factories);
    }

    /**
     * Starts the CLI, processing user inputs until 'exit' is entered.
     */
    public void start() {
        running = true;
        output.println("Welcome to the Parking System!");
        output.println("Type 'help' for available commands.");

        while (running) {
            output.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            processCommand(input);
        }
    }

    private void processCommand(String input) {
        String[] tokens = input.split("\\s+", -1); // Handle empty tokens
        if (tokens.length == 0 || tokens[0].isEmpty()) {
            output.println("Empty command. Type 'help' for available commands.");
            return;
        }
        String commandName = tokens[0].toLowerCase();

        try {
            CommandFactory factory = commandFactories.get(commandName);
            if (factory == null) {
                output.println("Unknown command: " + commandName + ". Type 'help' for available commands.");
                return;
            }
            output.println("Processing command: " + commandName);
            Command command = factory.createCommand(tokens);
            command.execute(output);
        } catch (ParkingException e) {
            output.println("Error: " + e.getMessage());
        } catch (Exception e) {
            output.println("Unexpected error: " + e.getMessage());
        }
    }
}

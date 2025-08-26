package com.example.design.LLD.ticTacToe;

import java.util.Scanner;

public class HumanPlayer implements Player{
    private final CellState symbol;
    private final Scanner scanner;

    public HumanPlayer(CellState symbol, Scanner scanner) {
        this.symbol = symbol;
        this.scanner = scanner;
    }

    @Override
    public CellState getSymbol() {
        return symbol;
    }

    @Override
    public int[] makeMove(Board board) {
        while (true) {
            try {
                System.out.println("Player " + symbol + ", enter row (0-2) and column (0-2): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                if (board.isValidMove(row, col)) {
                    return new int[]{row, col};
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Enter numbers between 0 and 2.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

}

package com.example.design.LLD.ticTacToe;

public class Board {
    private final CellState[][] grid;
    private final int size = 3;;

    public Board() {
        grid = new CellState[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = CellState.EMPTY;
            }
        }
    }


    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && grid[row][col] == CellState.EMPTY;
    }

    public void placeMove(int row, int col, CellState symbol) {
        if (!isValidMove(row, col)) {
            throw new IllegalArgumentException("Invalid move: cell is occupied or out of bounds");
        }
        grid[row][col] = symbol;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == CellState.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner() {
        // Check rows
        for (int i = 0; i < size; i++) {
            if (grid[i][0] != CellState.EMPTY && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < size; j++) {
            if (grid[0][j] != CellState.EMPTY && grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j]) {
                return true;
            }
        }
        // Check diagonals
        if (grid[0][0] != CellState.EMPTY && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return true;
        }
        if (grid[0][2] != CellState.EMPTY && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return true;
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] == CellState.EMPTY ? "-" : grid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}

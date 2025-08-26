package com.example.design.LLD.ticTacToe;

public interface Player {
    CellState getSymbol();
    int[] makeMove(Board board);
}

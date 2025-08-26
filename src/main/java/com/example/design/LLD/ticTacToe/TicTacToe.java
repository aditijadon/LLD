package com.example.design.LLD.ticTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player1 = new HumanPlayer(CellState.X, scanner);
        Player player2 = new HumanPlayer(CellState.O, scanner);
        Game game = new Game(player1, player2);
        game.play();
        scanner.close();
    }
}

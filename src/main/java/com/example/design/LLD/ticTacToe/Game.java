package com.example.design.LLD.ticTacToe;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void play() {
        while (true) {
            board.display();
            int[] move = currentPlayer.makeMove(board);
            board.placeMove(move[0], move[1], currentPlayer.getSymbol());

            if (board.hasWinner()) {
                board.display();
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                break;
            }
            if (board.isFull()) {
                board.display();
                System.out.println("It's a draw!");
                break;
            }
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}

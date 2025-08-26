package com.example.design.LLD.parkingLot.model;

public class SpotCoordinates {
    private int row;
    private int col;

    public SpotCoordinates(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "SpotCoordinates{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}

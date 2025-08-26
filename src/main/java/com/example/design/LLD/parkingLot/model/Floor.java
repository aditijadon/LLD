package com.example.design.LLD.parkingLot.model;


public class Floor {
    int id;
    AbstractParkingSpot[][] spots;

    // Contructor to create a defaulr floor with first row for bikes, last row for trucks, all other for cars
    public Floor(int id, int floorLength, int floorWidth) {
        this.id = id;
        this.spots = new AbstractParkingSpot[floorLength][floorWidth];
        for(int i=0; i<floorLength; i++){
            for(int j=0; j<floorWidth; j++){
                if(i == 0){
                    spots[i][j] = new CompactSpot(id,i,j);
                }
                else if(i == spots.length-1){
                    spots[i][j] = new LargeSpot(id,i,j);
                }
                else {
                    spots[i][j] = new RegularSpot(id,i,j);
                }
            }
        }
    }

//    public Floor(int id, AbstractParkingSpot[][] spots) {
//
//    }

    public AbstractParkingSpot[][] getSpots() {
        return spots;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", spots=" + (spots != null ? spots.length*spots[0].length + " spots" : "none") +
                '}';
    }
}

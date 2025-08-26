package com.example.design.DesignPatterns.decorator;

public class Espresso extends Beverage{
    Espresso(){
        description = "Espresso";
    }

    public int cost(){
        return 50;
    }
}

package com.example.design.DesignPatterns.decorator;

public class Decaf extends Beverage{
    Decaf(){
        description = "Decaf Coffee";
    }

    public int cost(){
        return 70;
    }
}

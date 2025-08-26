package com.example.design.DesignPatterns.decorator;

public abstract class Beverage {
    String description = "A Beverage";

    public String getDescription(){
        return description;
    }

    public abstract int cost();
}

package com.example.design.DesignPatterns.decorator;

public class Mocha extends CondimentDecorator{
    Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Mocha";
    }

    @Override
    public int cost() {
        return this.beverage.cost() + 20;
    }
}

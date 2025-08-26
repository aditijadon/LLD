package com.example.design.DesignPatterns.decorator;

public class WhippedCream extends CondimentDecorator{
    WhippedCream(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Whipped Cream";
    }

    @Override
    public int cost() {
        return this.beverage.cost() + 10;
    }
}

package com.example.design.DesignPatterns.decorator;

public class Starbuzz {
    public static void main(String[] args) {
        Beverage beverage1 = new Espresso();
        Beverage beverage2 = new Mocha(beverage1);
        Beverage beverage3 = new WhippedCream(beverage2);
        System.out.println(beverage1.getDescription() + ": " + beverage2.cost());
        System.out.println(beverage2.getDescription() + ": " + beverage2.cost());
        System.out.println(beverage3.getDescription() + ": " + beverage3.cost());
    }
}

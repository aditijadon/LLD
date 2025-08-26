package com.example.design.DesignPatterns.strategy.duck;

public class Driver {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.doFly();
        mallard.doQuack();
        mallard.display();
    }
}

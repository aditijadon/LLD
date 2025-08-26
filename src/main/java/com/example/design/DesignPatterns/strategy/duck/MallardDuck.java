package com.example.design.DesignPatterns.strategy.duck;

public class MallardDuck extends Duck{
    MallardDuck(){
        quackBehaviour = new SimpleQuack();
        flyBehaviour = new SimpleFly();
    }

    void display(){
        System.out.println("I look like a Mallard Duck");
    }
}

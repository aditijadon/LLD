package com.example.design.DesignPatterns.strategy.duck;

public class SimpleQuack implements IQuackBehaviour{
    public void quack(){
        System.out.println("Simple Quack!");
    }
}

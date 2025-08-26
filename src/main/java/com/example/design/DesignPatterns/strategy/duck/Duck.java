package com.example.design.DesignPatterns.strategy.duck;

public abstract class Duck {
    IQuackBehaviour quackBehaviour;
    IFlyBehaviour flyBehaviour;

    abstract void display();

    public void doQuack(){
        quackBehaviour.quack();
    }

    public void doFly() {
        flyBehaviour.fly();
    }
}

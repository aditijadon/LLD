package com.example.design.DesignPatterns.singleton;

public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();  //Eager Initialisation
    private EagerInitializedSingleton(){

    }
    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}

//Instance create at class loading whether the client require it or not

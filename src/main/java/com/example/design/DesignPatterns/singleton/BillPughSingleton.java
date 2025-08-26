package com.example.design.DesignPatterns.singleton;

public class BillPughSingleton {
    private BillPughSingleton(){}

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

// Alternative approach for thread-safe singleton
// When the singleton class is loaded, SingletonHelper class is not loaded into memory
// Only when getInstance() method called, this class gets loaded and creates the singleton class instance

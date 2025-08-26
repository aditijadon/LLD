package com.example.design.DesignPatterns.adapter;

public class Socket {
    public Volt getVolt(){
        return new Volt(120);
    }
}

package com.example.design.licious.service;

public interface ICache {
    public int get(int key);
    void put(int key, int value);
}

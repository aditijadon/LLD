package com.example.design.ThirdWave;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class Beverage {
    protected BeverageName name;
    protected double basePrice;
    protected Map<IngedientName, Integer> ingredients;

    public Beverage(BeverageName name, double basePrice){
        this.name = name;
        this.basePrice = basePrice;
        this.ingredients = new HashMap<>();
    }

    public abstract void prepare();
}

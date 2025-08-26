package com.example.design.ThirdWave;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> stock;
    private int capacity;

    Inventory(int capacity){
        this.capacity = capacity;
        this.stock = new HashMap<>();
        setBasicStock();
    }

    private void setBasicStock(){
        stock.put("Liquid Coffe", capacity);
        stock.put("milk", capacity);
        stock.put("chocolate syrup", capacity);
    }

    public boolean hasEnoughIngredients(Map<String, Integer> ingredients){
        for(Map.Entry<String, Integer> entry : ingredients.entrySet()){
            if(stock.getOrDefault(entry.getKey(), 0) < entry.getValue()){
                return false;
            }
        }
        return true;
    }

    public void updateStock(Map<String, Integer> ingredients){
        for(Map.Entry<String, Integer> entry : ingredients.entrySet()){
            stock.computeIfPresent(entry.getKey(), (k,v) -> v - entry.getValue());
        }
    }

    public void reFillIngredient(String ingredient, int quantity){
        throw new IllegalStateException("instant refilling not possible");
    }

    public int getStock(String ingredient){
        return stock.getOrDefault(ingredient, 0);
    }
}

package com.example.design.ThirdWave;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private Inventory inventory;
    private Map<String, Beverage> menu;
    private List<AddOn> addOns;

    public VendingMachine(int capacity){
        this.inventory = new Inventory(capacity);
        this.menu = new HashMap<>();
    }

    public double createBeverage(BeverageName beverageName, Map<AddOn, Integer> addOns){
//        Beverage b = new Cappuccino();
//        if(inventory.hasEnoughIngredients(b.getIngredients()){
//            for(AddOn a : addOns){
//                double total = b.basePrice + a.getPricePerunit()*
//            }
//        }
        // commenting out the whole method because it's incomplete
        return 30.0;
    }
}

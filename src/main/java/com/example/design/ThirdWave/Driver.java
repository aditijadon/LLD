package com.example.design.ThirdWave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(10);
        Map<AddOn, Integer> addOnsQuantities = new HashMap<>();
        addOnsQuantities.put(new AddOn(IngedientName.SUGAR, 1),1);
        addOnsQuantities.put(new AddOn(IngedientName.CARAMEL, 2), 1);

        System.out.println("Total price: " + machine.createBeverage(BeverageName.CAPPUCCINO, addOnsQuantities));
    }
}

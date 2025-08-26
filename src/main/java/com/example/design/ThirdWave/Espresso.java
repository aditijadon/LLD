package com.example.design.ThirdWave;

public class Espresso extends Beverage {
    public Espresso(){
        super(BeverageName.ESPRESSO, 2);
        ingredients.put(IngedientName.LIQUID_COFFEE,1);
    }

    @Override
    public void prepare(){
        System.out.println("Preparing your Expresso with 1 liquid coffee");
    }
}

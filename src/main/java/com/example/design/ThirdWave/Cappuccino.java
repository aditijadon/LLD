package com.example.design.ThirdWave;

public class Cappuccino extends Beverage {
    public Cappuccino(){
        super(BeverageName.CAPPUCCINO, 4);
        ingredients.put(IngedientName.LIQUID_COFFEE,1);
        ingredients.put(IngedientName.MILK,1);
    }

    @Override
    public void prepare(){
        System.out.println("Preparing your Cappuccino with 1 liquid coffee and 1 milk");
    }
}

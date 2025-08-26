package com.example.design.ThirdWave;

public class Latte extends Beverage{
    public Latte(){
        super(BeverageName.LATTE, 4);
        ingredients.put(IngedientName.LIQUID_COFFEE,1);
        ingredients.put(IngedientName.MILK,1);
        ingredients.put(IngedientName.CHOCOLATE_SYRUP,2);
    }

    @Override
    public void prepare(){
        System.out.println("Preparing your Latte with 1 liquid coffee, 1 milk and 1 ChocolateSyrup");
    }
}

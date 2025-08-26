package com.example.design.DesignPatterns.strategy.paymentStrategy;

public class GpayStrategy implements PaymentStrategy{
    private String UPI;

    GpayStrategy(String UPI){
        this.UPI = UPI;
    }

    @Override
    public void pay(int amount){
        System.out.println(amount +" paid through Gpay");
    }
}

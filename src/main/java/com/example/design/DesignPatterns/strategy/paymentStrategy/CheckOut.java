package com.example.design.DesignPatterns.strategy.paymentStrategy;

public class CheckOut {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("1234",10);
        Item item2 = new Item("5678",40);
        cart.addItem(item1);
        cart.addItem(item2);
        System.out.println("Total amount : " + cart.calculateTotal());

        //pay by Gpay
        cart.pay(new GpayStrategy("myupi@okbank"));

        //pay by credit card
        cart.pay(new CreditCardStrategy("Aditi", "12345678903456", "786", "12/30"));
    }
}

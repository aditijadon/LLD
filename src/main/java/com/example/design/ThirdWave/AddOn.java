package com.example.design.ThirdWave;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class AddOn {
    private IngedientName name;
    private double pricePerunit;

    public AddOn(IngedientName name, double pricePerunit){
        this.name = name;
        this.pricePerunit = pricePerunit;
    }
}

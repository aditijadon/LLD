package com.example.design.openTable.model;

import com.example.design.openTable.enums.City;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class Restaurant {
    private final String id;
    private final String name;
    private final String address;
    private final City city;
    private final List<Table> tables;

    public Restaurant(String id, String name, String address, City city){
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.tables = new ArrayList<>();
    }
}

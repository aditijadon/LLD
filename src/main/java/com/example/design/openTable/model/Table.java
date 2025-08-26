package com.example.design.openTable.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Table {
    private final String id;
    private final int capacity;
    private boolean isAvailable;
}

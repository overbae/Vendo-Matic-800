package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Item {
    public Chips(String name, BigDecimal price, String category, int quantity){
        super(name, price, category, quantity);

    }

    @Override
    public String getSound() {
        return "Crunch Crunch Yum!";
    }
}


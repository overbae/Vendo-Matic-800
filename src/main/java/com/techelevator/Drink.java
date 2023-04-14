package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item{
    public Drink(String name, BigDecimal price, String category, int quantity){
        super(name, price, category, quantity);

    }

    @Override
    public String getSound() {
        return "Glug Glug Yum!";
    }
}


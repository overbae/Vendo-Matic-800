package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item{
    public Drink(String name, BigDecimal price, String category, int quantity){
        super(name, price, category, quantity);
        // Calls the constructor of the superclass Item with the provided arguments

    }

    @Override
    public String getSound() {
        // Overrides the abstract method from the Item class to return the sound made by the Candy
        return "Glug Glug Yum!";
    }
}


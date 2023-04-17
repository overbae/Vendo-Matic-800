package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item{
    public Candy(String name, BigDecimal price, String category, int quantity){
        super(name, price, category, quantity);
        // Calls the constructor of the superclass Item with the provided arguments
    }

    @Override
    public String getSound() {
        // Overrides the abstract method from the Item class to return the sound made by the Candy
        return "Munch Munch Yum! \n";
    }
}



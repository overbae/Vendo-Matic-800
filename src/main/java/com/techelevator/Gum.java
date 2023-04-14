package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item{
    public Gum(String name, BigDecimal price, String category, int quantity){
        super(name, price, category, quantity);

    }

    @Override
    public String getSound() {
        return "Chew Chew Yum!";
    }
}


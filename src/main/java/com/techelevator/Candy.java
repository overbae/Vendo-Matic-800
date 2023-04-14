package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item{
    public Candy(String name, BigDecimal price, String category, int quantity){
        super(name, price, category, quantity);

    }

    @Override
    public String getSound() {
        return "Munch Munch Yum!";
    }
}


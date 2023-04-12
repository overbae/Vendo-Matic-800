package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Item {
    private String vendingPhrase = "Crunch Crunch, Yum!";

    public Chips (String name, BigDecimal price, String code, String category, int quantity) {
        super(name, price, code, category, quantity);
        this.setVendingPhrase(this.vendingPhrase);
    }
    @Override
    public void vendingLine(){
        System.out.println(vendingPhrase);
    }
}

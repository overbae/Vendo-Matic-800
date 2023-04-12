package com.techelevator;

import java.math.BigDecimal;

public class Drinks extends Item{
    private String vendingPhrase = "Glug Glug, Yum";
    public Drinks(String name, BigDecimal price, String code, String category, int quantity){
        super(name, price, code, category, quantity);
        this.setVendingPhrase(this.vendingPhrase);
    }

    @Override
    public void vendingLine() {
        System.out.println(vendingPhrase);
    }
}

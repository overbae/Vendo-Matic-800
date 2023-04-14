package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item{
    private String vendingPhrase = "Munch Munch, Yum!";
    public Candy(String name, BigDecimal price, String code, String category, int quantity){
        super(name, price, code, category, quantity);
        this.setVendingPhrase(this.vendingPhrase);
    }

    @Override
    public void vendingLine() {
        System.out.println(vendingPhrase);

    }
}

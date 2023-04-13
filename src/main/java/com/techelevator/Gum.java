package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item{
    private String vendingPhrase = "Chew Chew, Yum!";
    public Gum(String name, BigDecimal price, String code, String category, int quantity) {
        super(name, price, code, category, quantity);
        this.setVendingPhrase(this.vendingPhrase);
    }
    @Override
    public void vendingLine() {
        System.out.println(vendingPhrase);

    }
}
// commit/push for tyler

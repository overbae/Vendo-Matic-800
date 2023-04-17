package com.techelevator;

import java.math.BigDecimal;

public class Money {
    private BigDecimal balance;

    public Money() {
        this(BigDecimal.ZERO);
    }

    public Money(BigDecimal initialBalance) {
        balance = initialBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void addCash(BigDecimal depositAmount) {
        balance = balance.add(depositAmount);
    }


    public void moneySubtracted(BigDecimal amountSubtracted) {
        balance = balance.subtract(amountSubtracted);
    }


    public String coinReturn() {
        final BigDecimal QUARTER_VALUE = new BigDecimal("0.25");
        final BigDecimal DIME_VALUE = new BigDecimal("0.10");
        final BigDecimal NICKEL_VALUE = new BigDecimal("0.05");

        int cents = balance.multiply(new BigDecimal("100")).intValueExact();

        int quarters = cents / (QUARTER_VALUE.multiply(new BigDecimal("100")).intValueExact());
        cents -= quarters * (QUARTER_VALUE.multiply(new BigDecimal("100")).intValueExact());

        int dimes = cents / (DIME_VALUE.multiply(new BigDecimal("100")).intValueExact());
        cents -= dimes * (DIME_VALUE.multiply(new BigDecimal("100")).intValueExact());

        int nickels = cents / (NICKEL_VALUE.multiply(new BigDecimal("100")).intValueExact());
        cents -= nickels * (NICKEL_VALUE.multiply(new BigDecimal("100")).intValueExact());

        SalesLog.log(" GIVE CHANGE:", balance, BigDecimal.ZERO);
        balance = BigDecimal.ZERO;

        return "Your change is: " + quarters + " quarter(s), " + dimes + " dime(s), " + nickels + " nickel(s).";
    }

    @Override
    public String toString() {
        return "Current balance: $" + balance;
    }
}


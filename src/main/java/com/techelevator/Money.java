package com.techelevator;
import java.io.IOException;
import java.util.Scanner;

import static com.techelevator.Item.df;

public class Money {
    public double balance; // A public instance variable to hold the current balance

    // A default constructor that initializes the balance to 0
    public Money(){
        balance = 0;
    }

    // A constructor that takes a balance parameter and initializes the balance to the provided value
    public Money(double balance){
        this.balance = balance;
    }

    // A method that returns the current balance
    public double getBalance(){
        return balance;
    }

    // A method that takes a depositAmount parameter and adds it to the balance. It also logs the transaction in a SalesLog object.
    public void addCash(int depositAmount){
        SalesLog.log(" Feed Money", balance, balance + depositAmount);
        balance += depositAmount;
    }

    // A method that takes an amountSubtracted parameter and subtracts it from the balance
    public void moneySubtracted(double amountSubtracted){
        this.balance -= amountSubtracted;
    }

    // A method that calculates the change that should be returned based on the current balance and the coin denominations available.
    // It then resets the balance to 0 and logs the transaction in a SalesLog object. The method returns a string that includes the number of each coin denomination that should be returned as change.
    public String coinReturn(){
        final int QUARTER = 25;
        final int DIME = 10;
        final int NICKLE = 5;

        // Convert the balance to an integer value of cents and store it in the changeTrace variable
        int changeTrace = (int) (balance *= 100);

        // Initialize variables to hold the number of quarters, dimes, and nickels that will be returned as change
        int quartersNeededForReturn = 0;
        int dimesNeededForReturn = 0;
        int nicklesNeededForReturn = 0;

        // Loop through the changeTrace value and calculate the number of each coin denomination that should be returned as change
        while(changeTrace > 0) {
            if (changeTrace >= QUARTER){
                quartersNeededForReturn++;
                changeTrace -= QUARTER;
            } else if(changeTrace >= DIME){
                dimesNeededForReturn++;
                changeTrace -= DIME;
            } else if(changeTrace >= NICKLE){
                nicklesNeededForReturn++;
                changeTrace -= NICKLE;
            }
        }

        // Log the transaction in a SalesLog object and reset the balance to 0
        SalesLog.log(" Give Change", balance / 100, 0);
        balance = 0;

        // Return a string that includes the number of each coin denomination that should be returned as change
        return "Thank you for purchasing! \n \nYour change is: " +(quartersNeededForReturn) + "quarter" + (quartersNeededForReturn == 1 ? "" : "s") + ", " + dimesNeededForReturn + "dime" + (dimesNeededForReturn == 1 ? "" : "s") + ", " + "and " + nicklesNeededForReturn + " nickle" + (nicklesNeededForReturn == 1 ? "" : "s") + "!" ;
    }

    // An override of the toString method that returns a string that displays the current balance, formatted to two decimal places.
    @Override
    public String toString(){
        return "Your updated balance is: " + df.format(balance);
    }

}


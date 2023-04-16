package com.techelevator;

import java.math.BigDecimal;
import java.text.DecimalFormat;
public abstract class Item {
    public static DecimalFormat df = new DecimalFormat("$0.00"); // A DecimalFormat object to format the price of an item as currency
    private String name;           // name of the item
    private String code;           // code to identify the item
    private String category;       // category of the item
    private String vendingPhrase;  // phrase that describes how the item is dispensed
    private int quantity;          // quantity of the item
    private BigDecimal price;      // price of the item

    public Item(String name, BigDecimal price, String category, int quantity){
        // Constructor for Item class that sets the name, price, category, and quantity
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        // Method to return the name of the item
        return name;
    }

    public BigDecimal getPrice() {
        // Method to return the price of the item
        return price;
    }

    public String getCode(){
        // Method to return the code of the item
        return code;
    }

    public String getCategory(){
        // Method to return the category of the item
        return category;
    }

    public int getQuantity(){
        // Method to return the quantity of the item
        return quantity;
    }

    // Setter methods to set the values of the private variables
    public void setName(String name){
        this.name = name;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public void setCode(String code){
        this.code = code;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setVendingPhrase(String vendingPhrase){
        // Method to set the vending phrase for the item
        this.vendingPhrase = vendingPhrase;
    }

    public abstract String getSound();
    // An abstract method that returns the sound made by the item when dispensed. The implementation of this method will be provided by the subclasses.
}

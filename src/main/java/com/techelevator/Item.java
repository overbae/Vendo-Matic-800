package com.techelevator;

import java.math.BigDecimal;
public abstract class Item {
    private String name;
    private String code;
    private String category;
    private String vendingPhrase;
    private int quantity;
    private BigDecimal price;

    public Item(String name, BigDecimal price, String code, String category, int quantity){
        this.name = name;
        this.price = price;
        this.code = code;
        this.category = category;
        this.quantity = quantity;
    }

    // these are our getters
    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public String getCode(){
        return code;
    }
    public String getCategory(){
        return category;
    }
    public int getQuantity(){
        return quantity;
    }
    // these are our setters
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
        this.vendingPhrase = vendingPhrase;
    }

    public abstract void vendingLine();


    //public class Item {
//    String code;
//    String name;
//    BigDecimal price;
//    String category;
//    int quantity;
//
//    public Item(){}
//
//    public Item(String name, BigDecimal price, String category, int quantity){
//        this.name = name;
//        this.price = price;
//        this.category = category;
//        this.quantity = quantity;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
}

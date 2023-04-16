package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    // Create a new hash map to store the inventory data
    public Map<String, Item> inventory = new LinkedHashMap<>();

    // Method to load inventory data from a CSV file
    public void addItem(Item item, String itemDescription){
        item.setCode(itemDescription);
        inventory.put(item.getCode(), item);
    }
    public void inventoryLoader() {
        // Open the inventory file using a try-with-resources block
        try (Scanner inventoryInput = new Scanner(new File("vendingmachine.csv"))) {
            // Loop through each line of the file
            while (inventoryInput.hasNextLine()) {
                // Split the line into individual parts using the pipe character as a delimiter
                String[] itemDescription = inventoryInput.nextLine().split("\\|");
                Item item;

                // Create a new Chip, Candy, Drink, and Gum object based on the item type indicated in the file
                if (itemDescription[3].equals("Chip")) {
                    item = new Chips(itemDescription[1], new BigDecimal(itemDescription[2]), itemDescription[3], 5);
                    addItem(item, itemDescription[0]);
                }else if (itemDescription[3].equals("Candy")) {
                    item = new Candy(itemDescription[1], new BigDecimal(itemDescription[2]), itemDescription[3], 5);
                    addItem(item, itemDescription[0]);
                }else if (itemDescription[3].equals("Drink")) {
                    item = new Drink(itemDescription[1], new BigDecimal(itemDescription[2]), itemDescription[3], 5);
                    addItem(item, itemDescription[0]);
                }else if (itemDescription[3].equals("Gum")) {
                    item = new Gum(itemDescription[1], new BigDecimal(itemDescription[2]), itemDescription[3], 5);
                    addItem(item, itemDescription[0]);
                }

            }

            // Add the new Item object to the inventory map, using the item code as the key

        } catch (FileNotFoundException e) {
            System.err.println("The file doesn't exist.");
        }
    }

    // Method to display and format the items in the inventory
    public void itemDisplay() {
        // Print a header for the inventory display
        System.out.println("Code\tName\t\t\tPrice\tQuantity");
        // Print a separator line for the inventory display
        System.out.println("--------------------------------------------------");

        // Loop through each item in the inventory map
        for (Map.Entry<String, Item> item : inventory.entrySet()) {
            // Get the code, name, price, and quantity for the current item
            String code = item.getValue().getCode();
            String name = item.getValue().getName();
            double price = item.getValue().getPrice().doubleValue();
            int quantity = item.getValue().getQuantity();

            // If the item is out of stock, display a "Sold Out" message
            if (quantity == 0) {
                System.out.printf("%s\t%-20s\t%s\t%s\n", code, name, String.format("$%.2f", price), "Sold Out");
            }
            // Otherwise, display the item's code, name, price, and quantity left
            else {
                System.out.printf("%s\t%-20s\t%s\t%s\n", code, name, String.format("$%.2f", price), quantity);
            }
        }
    }



    // Method to generate vending sounds
   public String vendSound(Item item){
        return item.getSound();
   }
//    public String vendSound (String code){
//        String sound = "";
//        if (code.startsWith("A")) {
//            sound = "\nCrunch Crunch, Yum!";
//        } else if (code.startsWith("B")) {
//            sound = "\nMunch Munch, Yum!";
//        } else if (code.startsWith("C")) {
//            sound = "\nGlug Glug, Yum!";
//        } else if (code.startsWith("D")) {
//            sound = "\nChew Chew, Yum!";
//        }
//        return sound;
//    }

}
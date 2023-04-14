package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    // Create a new hash map to store the inventory data
    Map<String, Item> inventory = new LinkedHashMap<>();

    // Method to load inventory data from a CSV file
    public void inventoryLoader() {
        // Open the inventory file using a try-with-resources block
        try (Scanner inventoryInput = new Scanner(new File("vendingmachine.csv"))) {
            // Loop through each line of the file
            while (inventoryInput.hasNextLine()) {
                // Split the line into individual parts using the pipe character as a delimiter
                String[] itemDescription = inventoryInput.nextLine().split("\\|");

                // Create a new Item object based on the item type indicated in the file
                Item item = new Item(itemDescription[1], new BigDecimal(itemDescription[2]), itemDescription[3], 5);
                item.setCode(itemDescription[0]);
                inventory.put(item.getCode(), item);
            }

            // Add the new Item object to the inventory map, using the item code as the key

        } catch (FileNotFoundException e) {
            System.err.println("The file doesn't exist.");
        }
    }

    // Method to display the items in the inventory
    public void itemDisplay() {
        System.out.println("Code\tName\t\t\tPrice\tQuantity");
        System.out.println("--------------------------------------------------");

        for (Map.Entry<String, Item> item : inventory.entrySet()) {
            String code = item.getValue().getCode();
            String name = item.getValue().getName();
            double price = item.getValue().getPrice().doubleValue();
            int quantity = item.getValue().getQuantity();

            if (quantity == 0) {
                System.out.printf("%s\t%-20s\t%s\t%s\n", code, name, String.format("$%.2f", price), "Sold Out");
            } else {
                System.out.printf("%s\t%-20s\t%s\t%s\n", code, name, String.format("$%.2f", price), quantity);
            }
        }
    }


    // Method to generate vending sounds
    public String vendSound (String code){
        String sound = "";
        if (code.startsWith("A")) {
            sound = "\nCrunch Crunch, Yum!";
        } else if (code.startsWith("B")) {
            sound = "\nMunch Munch, Yum!";
        } else if (code.startsWith("C")) {
            sound = "\nGlug Glug, Yum!";
        } else if (code.startsWith("D")) {
            sound = "\nChew Chew, Yum!";
        }
        return sound;
    }
}
package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;


public class Inventory {
    Map<String, Item> inventory = new TreeMap<>();

    public Map<String, Item> inventoryLoader() {
        File listOfInventory = new File("vendingmachine.csv");
        try (Scanner inventoryInput = new Scanner(listOfInventory)) {
            while (inventoryInput.hasNextLine()) {
                String inputLine = inventoryInput.nextLine();
                String[] itemDescription = inputLine.split("\\|");
                for (String item : itemDescription) {
                    if (itemDescription[3].equals("Chip")) {
                        Chips chip = new Chips(itemDescription[1], BigDecimal.valueOf(Double.parseDouble(itemDescription[2])), itemDescription[0], itemDescription[3], 5);
                        inventory.put(itemDescription[0], chip);
                    } else if (itemDescription[3].equals("Candy")) {
                        Candy candy = new Candy(itemDescription[1], BigDecimal.valueOf(Double.parseDouble(itemDescription[2])), itemDescription[0], itemDescription[3], 5);
                        inventory.put(itemDescription[0], candy);
                    } else if (itemDescription[3].equals("Drink")) {
                        Drinks drink = new Drinks(itemDescription[1], BigDecimal.valueOf(Double.parseDouble(itemDescription[2])), itemDescription[0], itemDescription[3], 5);
                        inventory.put(itemDescription[0], drink);
                    } else if (itemDescription[3].equals("Gum")) {
                        Gum gum = new Gum(itemDescription[1], BigDecimal.valueOf(Double.parseDouble(itemDescription[2])), itemDescription[0], itemDescription[3], 5);
                        inventory.put(itemDescription[0], gum);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file doesn't exist.");
        }
        return inventory;
    }

    public void itemDisplay(Map<String, Item> inventory) {
        for (Map.Entry<String, Item> item : this.inventory.entrySet()) {
            if (item.getValue().getQuantity() == 0) {
                System.out.println(item.getValue().getCode() + " Item is Sold Out");
            } else {
                System.out.println(item.getValue().getCode() + " " + item.getValue().getName() + " " + String.format("%.2f", item.getValue().getPrice()) + ", " + item.getValue().getQuantity() + " left.");
            }
        }
    }
}
//    Map<String, Item> inventory = new LinkedHashMap<String, Item>();
//
//    public void loadInventory() {
//        String fileName = "/Users/ransom/Desktop/merit-america/module-1-capstone/vendingmachine.csv";
//        File file = new File(fileName);
//        try (Scanner inputFile = new Scanner(file)) {
//            while (inputFile.hasNextLine()) {
//                String lineOfInput = inputFile.nextLine();
//                String[] splitInput = lineOfInput.split("\\|");
//                Item item = new Item(splitInput[1], new BigDecimal(splitInput[2]), splitInput[3], 5); // this splits the csv file values by the Product Name, Price, Category, and it sets the number of said product to 5
//                item.setCode(splitInput[0]);
//                inventory.put(item.getCode(), item);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("\nFile does not exist");
//        }
//    }

// test for commit.


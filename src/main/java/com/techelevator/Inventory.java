package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    // Method to load inventory data from a CSV file
    public Map<String, Item> inventoryLoader() {
        // Create a new hash map to store the inventory data
        Map<String, Item> inventory = new HashMap<>();

        // Open the inventory file using a try-with-resources block
        try (Scanner inventoryInput = new Scanner(new File("vendingmachine.csv"))) {
            // Loop through each line of the file
            while (inventoryInput.hasNextLine()) {
                // Split the line into individual parts using the pipe character as a delimiter
                String[] itemDescription = inventoryInput.nextLine().split("\\|");

                // Create a new Item object based on the item type indicated in the file
                Item item = null;
                if (itemDescription[3].equals("Chip")) {
                    item = new Chips(itemDescription[1], BigDecimal.valueOf(Double.parseDouble(itemDescription[2])), itemDescription[0], itemDescription[3], 5);
                } else if (itemDescription[3].equals("Candy")) {
                    item = new Candy(itemDescription[1], BigDecimal.valueOf(Double.parseDouble(itemDescription[2])), itemDescription[0], itemDescription[3], 5);
                } else if (itemDescription[3].equals("Drink")) {
                    item = new Drinks(itemDescription[1], BigDecimal.valueOf(Double.parseDouble(itemDescription[2])), itemDescription[0], itemDescription[3], 5);
                } else if (itemDescription[3].equals("Gum")) {
                    item = new Gum(itemDescription[1], BigDecimal.valueOf(Double.parseDouble(itemDescription[2])), itemDescription[0], itemDescription[3], 5);
                }

                // Add the new Item object to the inventory map, using the item code as the key
                inventory.put(itemDescription[0], item);
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file doesn't exist.");
        }

        // Return the completed inventory map
        return inventory;
    }

    // Method to display the items in the inventory
    public void itemDisplay(Map<String, Item> inventory) {
        // Loop through each item in the inventory map
        for (Map.Entry<String, Item> item : inventory.entrySet()) {
            // If the item is out of stock, print a message indicating that it's sold out
            if (item.getValue().getQuantity() == 0) {
                System.out.println(item.getValue().getCode() + " Item is Sold Out");
            }
            // Otherwise, print the item code, name, price, and quantity left
            else {
                System.out.println(item.getValue().getCode() + " " + item.getValue().getName() + " " + String.format("%.2f", item.getValue().getPrice()) + ", " + item.getValue().getQuantity() + " left.");
            }
        }
    }
}






//public class Inventory {
//    Map<String, Item> inventory = new TreeMap<>();
//
//    public Map<String, Item> inventoryLoader() {
//        File listOfInventory = new File("vendingmachine.csv");
//        try (Scanner inventoryInput = new Scanner(listOfInventory)) {
//            while (inventoryInput.hasNextLine()) {
//                String inputLine = inventoryInput.nextLine();
//                String[] itemDescription = inputLine.split("\\|");
//                for (String item : itemDescription) {
//                    if (itemDescription[3].equals("Chip")) {
//                        Chips chip = new Chips(itemDescription[1], BigDecimal.valueOf(Double.parseDouble(itemDescription[2])), itemDescription[0], itemDescription[3], 5);
//                        inventory.put(itemDescription[0], chip);
//                    } else if (itemDescription[3].equals("Candy")) {
//                        Candy candy = new Candy(itemDescription[1], BigDecimal.valueOf(Double.parseDouble(itemDescription[2])), itemDescription[0], itemDescription[3], 5);
//                        inventory.put(itemDescription[0], candy);
//                    } else if (itemDescription[3].equals("Drink")) {
//                        Drinks drink = new Drinks(itemDescription[1], BigDecimal.valueOf(Double.parseDouble(itemDescription[2])), itemDescription[0], itemDescription[3], 5);
//                        inventory.put(itemDescription[0], drink);
//                    } else if (itemDescription[3].equals("Gum")) {
//                        Gum gum = new Gum(itemDescription[1], BigDecimal.valueOf(Double.parseDouble(itemDescription[2])), itemDescription[0], itemDescription[3], 5);
//                        inventory.put(itemDescription[0], gum);
//                    }
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.err.println("The file doesn't exist.");
//        }
//        return inventory;
//    }
//
//    public void itemDisplay(Map<String, Item> inventory) {
//        for (Map.Entry<String, Item> item : this.inventory.entrySet()) {
//            if (item.getValue().getQuantity() == 0) {
//                System.out.println(item.getValue().getCode() + " Item is Sold Out");
//            } else {
//                System.out.println(item.getValue().getCode() + " " + item.getValue().getName() + " " + String.format("%.2f", item.getValue().getPrice()) + ", " + item.getValue().getQuantity() + " left.");
//            }
//        }
//    }
//}




// old code provided by friend


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


package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    Map<String, Item> inventory = new LinkedHashMap<String, Item>();

    public void loadInventory() {
        String fileName = "/Users/ransom/Desktop/merit-america/module-1-capstone/vendingmachine.csv";
        File file = new File(fileName);
        try (Scanner inputFile = new Scanner(file)) {
            while (inputFile.hasNextLine()) {
                String lineOfInput = inputFile.nextLine();
                String[] splitInput = lineOfInput.split("\\|");
                Item item = new Item(splitInput[1], new BigDecimal(splitInput[2]), splitInput[3], 5);
                item.setCode(splitInput[0]);
                inventory.put(item.getCode(), item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nFile does not exist");
        }
    }
}

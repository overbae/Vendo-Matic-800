//package com.techelevator.view;

package com.techelevator.view;

import com.techelevator.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class InventoryTest {
    private Inventory inventory;

    @Before
    public void setUp() {
        inventory = new Inventory();
        inventory.addItem(new Chips("Potato Crisps", new BigDecimal("3.05"), "Chip", 5), "A1");
        inventory.addItem(new Candy("Wonka Bar", new BigDecimal("1.50"), "Candy", 5), "B1");
        inventory.addItem(new Drink("Cola", new BigDecimal("1.25"), "Drink", 5), "C1");
        inventory.addItem(new Gum("Chiclets", new BigDecimal("0.75"), "Gum", 5), "D1");
    }

    @Test
    public void addItem_addsItemToInventory() {
        inventory.addItem(new Chips("Doritos", new BigDecimal("3.25"), "Chip", 5), "E1");
        Assert.assertEquals("Doritos", inventory.inventory.get("E1").getName());
    }

    @Test
    public void inventoryLoader_loadsInventoryFromFile() {
        inventory.inventoryLoader();
        Assert.assertEquals("Potato Crisps", inventory.inventory.get("A1").getName());
        Assert.assertEquals(new BigDecimal("3.05"), inventory.inventory.get("A1").getPrice());
        Assert.assertEquals("Chip", inventory.inventory.get("A1").getCategory());
        Assert.assertEquals(5, inventory.inventory.get("A1").getQuantity());
    }

    @Test
    public void vendSound_returnsVendingSoundForItem() {
        Assert.assertEquals("Crunch Crunch Yum!", inventory.vendSound(inventory.inventory.get("A1")));
        Assert.assertEquals("Munch Munch Yum!", inventory.vendSound(inventory.inventory.get("B1")));
        Assert.assertEquals("Glug Glug Yum!", inventory.vendSound(inventory.inventory.get("C1")));
        Assert.assertEquals("Chew Chew Yum!", inventory.vendSound(inventory.inventory.get("D1")));
    }
}

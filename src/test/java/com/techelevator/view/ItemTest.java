//package com.techelevator.view;

package com.techelevator.view;

import com.techelevator.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ItemTest {

    private Item testItem;

    @Before
    public void setup() {
        testItem = new Item("Test Item", new BigDecimal("1.00"), "Test Category", 5) {
            @Override
            public String getSound() {
                return null;
            }
        };
    }

    @Test
    public void getName_returnsName() {
        String expected = "Test Item";
        String actual = testItem.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPrice_returnsPrice() {
        BigDecimal expected = new BigDecimal("1.00");
        BigDecimal actual = testItem.getPrice();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCategory_returnsCategory() {
        String expected = "Test Category";
        String actual = testItem.getCategory();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getQuantity_returnsQuantity() {
        int expected = 5;
        int actual = testItem.getQuantity();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setName_changesName() {
        String expected = "New Test Item Name";
        testItem.setName(expected);
        String actual = testItem.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPrice_changesPrice() {
        BigDecimal expected = new BigDecimal("2.00");
        testItem.setPrice(expected);
        BigDecimal actual = testItem.getPrice();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setCategory_changesCategory() {
        String expected = "New Test Category";
        testItem.setCategory(expected);
        String actual = testItem.getCategory();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setQuantity_changesQuantity() {
        int expected = 10;
        testItem.setQuantity(expected);
        int actual = testItem.getQuantity();
        Assert.assertEquals(expected, actual);
    }

}
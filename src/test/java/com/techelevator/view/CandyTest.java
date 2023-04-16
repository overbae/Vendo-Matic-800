//package com.techelevator.view;
package com.techelevator.view;

import java.math.BigDecimal;

import com.techelevator.Candy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class CandyTest {
    private Candy candy;

    @Before
    public void setup() {
        candy = new Candy("Snickers", new BigDecimal("1.50"), "Candy", 5);
    }

    @Test
    public void candy_has_correct_name() {
        String expectedName = "Snickers";
        String actualName = candy.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void candy_has_correct_price() {
        BigDecimal expectedPrice = new BigDecimal("1.50");
        BigDecimal actualPrice = candy.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void candy_has_correct_category() {
        String expectedCategory = "Candy";
        String actualCategory = candy.getCategory();
        Assert.assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void candy_has_correct_quantity() {
        int expectedQuantity = 5;
        int actualQuantity = candy.getQuantity();
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void candy_makes_correct_sound() {
        String expectedSound = "Munch Munch Yum!";
        String actualSound = candy.getSound();
        Assert.assertEquals(expectedSound, actualSound);
    }

}

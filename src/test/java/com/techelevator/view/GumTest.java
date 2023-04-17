//package com.techelevator.view;
package com.techelevator.view;

import java.math.BigDecimal;

import com.techelevator.Gum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {

    private Gum gum;

    @Before
    public void setup() {
        gum = new Gum("Orbit", new BigDecimal("0.75"), "Gum", 7);
    }

    @Test
    public void gum_has_correct_name() {
        String expectedName = "Orbit";
        String actualName = gum.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void gum_has_correct_price() {
        BigDecimal expectedPrice = new BigDecimal("0.75");
        BigDecimal actualPrice = gum.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void gum_has_correct_category() {
        String expectedCategory = "Gum";
        String actualCategory = gum.getCategory();
        Assert.assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void gum_has_correct_quantity() {
        int expectedQuantity = 7;
        int actualQuantity = gum.getQuantity();
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void gum_makes_correct_sound() {
        String expectedSound = "Chew Chew Yum! \n";
        String actualSound = gum.getSound();
        Assert.assertEquals(expectedSound, actualSound);
    }
}

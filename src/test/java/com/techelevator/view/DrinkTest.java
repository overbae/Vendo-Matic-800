//package com.techelevator.view;
package com.techelevator.view;

import java.math.BigDecimal;

import com.techelevator.Drink;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {

        private Drink drink;

        @Before
        public void setup() {
            drink = new Drink("Coca-Cola", new BigDecimal("1.50"), "Drink", 4);
        }

        @Test
        public void drink_has_correct_name() {
            String expectedName = "Coca-Cola";
            String actualName = drink.getName();
            Assert.assertEquals(expectedName, actualName);
        }

        @Test
        public void drink_has_correct_price() {
            BigDecimal expectedPrice = new BigDecimal("1.50");
            BigDecimal actualPrice = drink.getPrice();
            Assert.assertEquals(expectedPrice, actualPrice);
        }

        @Test
        public void drink_has_correct_category() {
            String expectedCategory = "Drink";
            String actualCategory = drink.getCategory();
            Assert.assertEquals(expectedCategory, actualCategory);
        }

        @Test
        public void drink_has_correct_quantity() {
            int expectedQuantity = 4;
            int actualQuantity = drink.getQuantity();
            Assert.assertEquals(expectedQuantity, actualQuantity);
        }

        @Test
        public void drink_makes_correct_sound() {
            String expectedSound = "Glug Glug Yum! \n";
            String actualSound = drink.getSound();
            Assert.assertEquals(expectedSound, actualSound);
        }
    }


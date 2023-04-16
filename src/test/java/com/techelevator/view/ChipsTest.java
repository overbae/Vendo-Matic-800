//package com.techelevator.view;


package com.techelevator.view;

import java.math.BigDecimal;

import com.techelevator.Chips;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

    public class ChipsTest {

        private Chips chips;

        @Before
        public void setup() {
            chips = new Chips("Lays", new BigDecimal("1.25"), "Chips", 3);
        }

        @Test
        public void chips_has_correct_name() {
            String expectedName = "Lays";
            String actualName = chips.getName();
            Assert.assertEquals(expectedName, actualName);
        }

        @Test
        public void chips_has_correct_price() {
            BigDecimal expectedPrice = new BigDecimal("1.25");
            BigDecimal actualPrice = chips.getPrice();
            Assert.assertEquals(expectedPrice, actualPrice);
        }

        @Test
        public void chips_has_correct_category() {
            String expectedCategory = "Chips";
            String actualCategory = chips.getCategory();
            Assert.assertEquals(expectedCategory, actualCategory);
        }

        @Test
        public void chips_has_correct_quantity() {
            int expectedQuantity = 3;
            int actualQuantity = chips.getQuantity();
            Assert.assertEquals(expectedQuantity, actualQuantity);
        }

        @Test
        public void chips_makes_correct_sound() {
            String expectedSound = "Crunch Crunch Yum!";
            String actualSound = chips.getSound();
            Assert.assertEquals(expectedSound, actualSound);
        }
    }


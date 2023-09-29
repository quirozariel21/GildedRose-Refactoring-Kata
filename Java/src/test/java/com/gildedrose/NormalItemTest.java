package com.gildedrose;

import com.gildedrose.items.AbstractItem;
import com.gildedrose.items.Normal;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalItemTest {

    private AbstractItem[] items;
    private GildedRoseService app;

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class SellIn_decrement_and_quality_decrement_by_1 {

        @BeforeEach
        public  void setUp() {
            items = new Normal[] {
                new Normal("+5 Dexterity Vest", 10, 20),
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(9, items[0].sellIn);
            assertEquals(19, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(8, items[0].sellIn);
            assertEquals(18, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
            updateQualityPerDay(3);
            assertEquals(7, items[0].sellIn);
            assertEquals(17, items[0].quality);
        }

    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class The_quality_of_an_item_is_never_negative {
        @BeforeEach
        public  void setUp() {
            items = new Normal[] {
                new Normal("+5 Dexterity Vest", 3, 2),
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(2, items[0].sellIn);
            assertEquals(1, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(1, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
            updateQualityPerDay(3);
            assertEquals(0, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterFourDay() {
            updateQualityPerDay(4);
            assertEquals(-1, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }
    }


    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast {

        @BeforeEach
        public  void setUp() {
            items = new Normal[] {
                new Normal("+5 Dexterity Vest", 1, 10),
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(0, items[0].sellIn);
            assertEquals(9, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(-1, items[0].sellIn);
            assertEquals(7, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
            updateQualityPerDay(3);
            assertEquals(-2, items[0].sellIn);
            assertEquals(5, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterFourDay() {
            updateQualityPerDay(4);
            assertEquals(-3, items[0].sellIn);
            assertEquals(3, items[0].quality);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast_and_quality_is_never_negative {

        @BeforeEach
        public  void setUp() {
            items = new Normal[] {
                new Normal("+5 Dexterity Vest", 1, 4),
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(0, items[0].sellIn);
            assertEquals(3, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(-1, items[0].sellIn);
            assertEquals(1, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
            updateQualityPerDay(3);
            assertEquals(-2, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterFourDay() {
            updateQualityPerDay(4);
            assertEquals(-3, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }
    }

    private void updateQualityPerDay(int days) {
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
    }
}

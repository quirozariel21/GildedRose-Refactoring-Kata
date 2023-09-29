package com.gildedrose;

import com.gildedrose.items.AbstractItem;
import com.gildedrose.items.Conjured;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredTest {

    private AbstractItem[] items;
    private GildedRoseServiceImpl app;

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class SellIn_decrement_and_quality_decrement_by_2 {
        @BeforeEach
        public  void setUp() {
            items = new Conjured[] {
                new Conjured( 3, 6),
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(2, items[0].sellIn);
            assertEquals(4, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(1, items[0].sellIn);
            assertEquals(2, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
            updateQualityPerDay(3);
            assertEquals(0, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class The_quality_of_an_item_is_never_negative {
        @BeforeEach
        public  void setUp() {
            items = new Conjured[] {
                new Conjured(2, 4), //
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(1, items[0].sellIn);
            assertEquals(2, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(0, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
            updateQualityPerDay(3);
            assertEquals(-1, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterFourDay() {
            updateQualityPerDay(4);
            assertEquals(-2, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class after_the_sale_date_its_quality_decreases_2_units_per_day {
        @BeforeEach
        public  void setUp() {
            items = new Conjured[] {
                new Conjured(2, 7), //
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(1, items[0].sellIn);
            assertEquals(5, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(0, items[0].sellIn);
            assertEquals(3, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
            updateQualityPerDay(3);
            assertEquals(-1, items[0].sellIn);
            assertEquals(1, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterFourDay() {
            updateQualityPerDay(4);
            assertEquals(-2, items[0].sellIn);
            assertEquals(0, items[0].quality);
        }
    }

    private void updateQualityPerDay(int days) {
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
    }
}

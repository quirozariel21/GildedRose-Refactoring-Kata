package com.gildedrose;

import com.gildedrose.items.AbstractItem;
import com.gildedrose.items.AgedBrie;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    private AbstractItem[] items;
    private GildedRoseService app;

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class item_can_never_have_its_quality_increase_above_50 {
        @BeforeEach
        public  void setUp() {
            items = new AgedBrie[] {
                new AgedBrie(3, 48)
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(2, items[0].sellIn);
            assertEquals(49, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(1, items[0].sellIn);
            assertEquals(50, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
            updateQualityPerDay(3);
            assertEquals(0, items[0].sellIn);
            assertEquals(50, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterFourDay() {
           updateQualityPerDay(4);
            assertEquals(-1, items[0].sellIn);
            assertEquals(50, items[0].quality);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class after_the_sale_date_its_quality_increases_2_units_per_day {
        @BeforeEach
        public  void setUp() {
            items = new AgedBrie[] {
                new AgedBrie(1, 7)
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(0, items[0].sellIn);
            assertEquals(8, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(-1, items[0].sellIn);
            assertEquals(10, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
           updateQualityPerDay(3);
            assertEquals(-2, items[0].sellIn);
            assertEquals(12, items[0].quality);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class after_the_sale_date_its_quality_increases_2_units_and_can_never_increase_above_50 {
        @BeforeEach
        public  void setUp() {
            items = new AgedBrie[] {
                new AgedBrie(1, 46)
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(0, items[0].sellIn);
            assertEquals(47, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
          updateQualityPerDay(2);
            assertEquals(-1, items[0].sellIn);
            assertEquals(49, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
            updateQualityPerDay(3);
            assertEquals(-2, items[0].sellIn);
            assertEquals(50, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterFourDay() {
            updateQualityPerDay(4);
            assertEquals(-3, items[0].sellIn);
            assertEquals(50, items[0].quality);
        }
    }
    private void updateQualityPerDay(int days) {
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
    }
}

package com.gildedrose;

import com.gildedrose.items.AbstractItem;
import com.gildedrose.items.Backstage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstageTest {

    private AbstractItem[] items;
    private GildedRoseService app;

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Given_SellIn_Greater_than_10_then_SellIn_decrement_and_quality_increment_by_1 {
        @BeforeEach
        public  void setUp() {
            items = new Backstage[] {
                new Backstage(15, 20),
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(14, items[0].sellIn);
            assertEquals(21, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(13, items[0].sellIn);
            assertEquals(22, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
            updateQualityPerDay(3);
            assertEquals(12, items[0].sellIn);
            assertEquals(23, items[0].quality);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Given_SellIn_less_or_equal_than_10_then_SellIn_decrement_and_quality_increment_by_2 {
        @BeforeEach
        public  void setUp() {
            items = new Backstage[] {
                new Backstage(10, 43), //
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(9, items[0].sellIn);
            assertEquals(45, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(8, items[0].sellIn);
            assertEquals(47, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
            updateQualityPerDay(3);
            assertEquals(7, items[0].sellIn);
            assertEquals(49, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterFourDay() {
            updateQualityPerDay(4);
            assertEquals(6, items[0].sellIn);
            assertEquals(50, items[0].quality);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Given_SellIn_less_or_equal_than_5_then_SellIn_decrement_and_quality_increment_by_3 {
        @BeforeEach
        public  void setUp() {
            items = new Backstage[] {
                new Backstage(5, 43), //
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(4, items[0].sellIn);
            assertEquals(46, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(3, items[0].sellIn);
            assertEquals(49, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
            updateQualityPerDay(3);
            assertEquals(2, items[0].sellIn);
            assertEquals(50, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterFourDay() {
            updateQualityPerDay(4);
            assertEquals(1, items[0].sellIn);
            assertEquals(50, items[0].quality);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Given_SellIn_less_than_0_then_SellIn_decrement_and_quality_equal_to_0 {
        @BeforeEach
        public  void setUp() {
            items = new Backstage[] {
                new Backstage(2, 20), //
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(1, items[0].sellIn);
            assertEquals(23, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(0, items[0].sellIn);
            assertEquals(26, items[0].quality);
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

    private void updateQualityPerDay(int days) {
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
    }
}

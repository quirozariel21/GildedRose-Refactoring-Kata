package com.gildedrose;

import com.gildedrose.items.AbstractItem;
import com.gildedrose.items.Sulfuras;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {

    private AbstractItem[] items;
    private GildedRoseServiceImpl app;

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class SellIn_and_quality_no_change {
        @BeforeEach
        public  void setUp() {
            items = new Sulfuras[] {
                new Sulfuras( 0),
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(0, items[0].sellIn);
            assertEquals(80, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(0, items[0].sellIn);
            assertEquals(80, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterThreeDay() {
            updateQualityPerDay(3);
            assertEquals(0, items[0].sellIn);
            assertEquals(80, items[0].quality);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class When_sellIn_is_negative_quality_and_sellIn_no_change {
        @BeforeEach
        public  void setUp() {
            items = new Sulfuras[] {
                new Sulfuras(-1), //
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(-1, items[0].sellIn);
            assertEquals(80, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(-1, items[0].sellIn);
            assertEquals(80, items[0].quality);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class When_quality_is_distinct_to_80_then_it_no_change_original_value {
        @BeforeEach
        public  void setUp() {
            items = new Sulfuras[] {
                new Sulfuras( 2, 5), //
            };
            app = new GildedRoseServiceImpl(items);
        }

        @Test
        public void testUpdateQualityAfterOneDay() {
            app.updateQuality();
            assertEquals(2, items[0].sellIn);
            assertEquals(5, items[0].quality);
        }

        @Test
        public void testUpdateQualityAfterTwoDay() {
            updateQualityPerDay(2);
            assertEquals(2, items[0].sellIn);
            assertEquals(5, items[0].quality);
        }
    }

    private void updateQualityPerDay(int days) {
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
    }
}

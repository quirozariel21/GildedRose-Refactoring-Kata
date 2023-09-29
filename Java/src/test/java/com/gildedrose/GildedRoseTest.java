package com.gildedrose;

import com.gildedrose.items.Normal;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private Item[] items;
    private GildedRose app;

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class AgedBrieTest {
        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class item_can_never_have_its_quality_increase_above_50 {
            @BeforeEach
            public  void setUp() {
                items = new Item[] {
                    new Item("Aged Brie", 3, 48)
                };
                app = new GildedRose(items);
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
                items = new Item[] {
                    new Item("Aged Brie", 1, 7)
                };
                app = new GildedRose(items);
            }

            @Test
            public void testUpdateQualityAfterOneDay() {
                app.updateQuality();
                assertEquals(0, items[0].sellIn);
                assertEquals(8, items[0].quality);
            }

            @Test
            public void testUpdateQualityAfterTwoDay() {
                int days = 2;
                for (int i = 0; i < days; i++) {
                    app.updateQuality();
                }
                assertEquals(-1, items[0].sellIn);
                assertEquals(10, items[0].quality);
            }

            @Test
            public void testUpdateQualityAfterThreeDay() {
                int days = 3;
                for (int i = 0; i < days; i++) {
                    app.updateQuality();
                }
                assertEquals(-2, items[0].sellIn);
                assertEquals(12, items[0].quality);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class after_the_sale_date_its_quality_increases_2_units_and_can_never_increase_above_50 {
            @BeforeEach
            public  void setUp() {
                items = new Item[] {
                    new Item("Aged Brie",1, 46)
                };
                app = new GildedRose(items);
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

    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class BackstageTest {
        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class Given_SellIn_Greater_than_10_then_SellIn_decrement_and_quality_increment_by_1 {
            @BeforeEach
            public  void setUp() {
                items = new Item[] {
                    new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                };
                app = new GildedRose(items);
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
                items = new Item[] {
                    new Item("Backstage passes to a TAFKAL80ETC concert", 10, 43), //
                };
                app = new GildedRose(items);
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
                items = new Item[] {
                    new Item("Backstage passes to a TAFKAL80ETC concert", 5, 43), //
                };
                app = new GildedRose(items);
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
                items = new Item[] {
                    new Item("Backstage passes to a TAFKAL80ETC concert", 2, 20), //
                };
                app = new GildedRose(items);
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
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class SulfurasTest {

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class SellIn_and_quality_no_change {
            @BeforeEach
            public  void setUp() {
                items = new Item[] {
                    new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                };
                app = new GildedRose(items);
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
                items = new Item[] {
                    new Item("Sulfuras, Hand of Ragnaros", -1, 80)
                };
                app = new GildedRose(items);
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
                items = new Item[] {
                    new Item("Sulfuras, Hand of Ragnaros", 2, 5), //
                };
                app = new GildedRose(items);
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

    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class NormalItemTest {
        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class SellIn_decrement_and_quality_decrement {

            @BeforeEach
            public  void setUp() {
                items = new Normal[] {
                    new Normal("+5 Dexterity Vest", 10, 20),
                };
                app = new GildedRose(items);
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
                app = new GildedRose(items);
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
                app = new GildedRose(items);
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
        class Once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast_and_ {

            @BeforeEach
            public  void setUp() {
                items = new Normal[] {
                    new Normal("+5 Dexterity Vest", 1, 4),
                };
                app = new GildedRose(items);
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
    }
    private void updateQualityPerDay(int days) {
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
    }

}

package com.gildedrose.items;

public class Sulfuras extends AbstractItem {

    public Sulfuras(int sellIn) {
        super("Sulfuras, Hand of Ragnaros", sellIn, 80);
    }

    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    public void updateSellInAndQuality() {
        // NO CHANGE
    }
}

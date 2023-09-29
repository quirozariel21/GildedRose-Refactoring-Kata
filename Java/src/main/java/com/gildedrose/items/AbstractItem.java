package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class AbstractItem extends Item {

    public AbstractItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void updateSellInAndQuality();
}

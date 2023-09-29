package com.gildedrose;

import com.gildedrose.items.AbstractItem;

import java.util.Arrays;
import java.util.List;

public class GildedRoseServiceImpl implements GildedRoseService {

    private List<AbstractItem> items;

    public GildedRoseServiceImpl(AbstractItem[] items) {
        this.items = Arrays.asList(items);
    }

    @Override
    public void updateQuality() {
        for (AbstractItem item : items) {
            item.updateSellInAndQuality();
        }
    }
}

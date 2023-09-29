package com.gildedrose.items;

public class Normal extends AbstractItem {

    public Normal(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateSellInAndQuality() {
        this.quality = sellIn > 0? this.quality - 1: this.quality - 2;

        this.sellIn-- ;

        if(this.quality < 0) {
            this.quality = 0;
        }
    }
}

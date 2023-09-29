package com.gildedrose.items;


public class Conjured extends AbstractItem {

    public Conjured(int sellIn, int quality) {
        super("Conjured Mana Cake", sellIn, quality);
    }

    @Override
    public void updateSellInAndQuality() {
        this.quality = this.quality - 2;
        this.sellIn-- ;

        if(this.quality < 0) {
            this.quality = 0;
        }
    }
}

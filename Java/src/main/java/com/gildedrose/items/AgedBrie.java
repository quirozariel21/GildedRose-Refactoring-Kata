package com.gildedrose.items;

public class AgedBrie extends AbstractItem {

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateSellInAndQuality() {
        this.quality = this.sellIn > 0 ? this.quality + 1 :  this.quality + 2;

        this.sellIn-- ;

        if(this.quality > 50) {
            this.quality = 50;
        }
    }
}

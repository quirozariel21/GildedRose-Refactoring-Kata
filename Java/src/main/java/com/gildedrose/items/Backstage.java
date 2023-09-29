package com.gildedrose.items;

public class Backstage extends AbstractItem {

    public Backstage(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateSellInAndQuality() {
        if(sellIn > 5 && sellIn <= 10) {
            this.quality = this.quality + 2;
        } else if(sellIn >= 1 && sellIn <= 5) {
            this.quality = this.quality + 3;
        } else if(sellIn <= 0){
            this.quality = 0;
        } else {
            this.quality++ ;
        }

        this.sellIn-- ;

        if(this.quality > 50) {
            this.quality = 50;
        }
    }
}

package com.gildedrose;

import com.gildedrose.items.*;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        AbstractItem[] items = new AbstractItem[] {
            new Normal("+5 Dexterity Vest", 10, 20), //
            new AgedBrie(2, 0), //
            new Normal("Elixir of the Mongoose", 5, 7), //
            new Sulfuras(0 ), //
            new Sulfuras(-1),
            new Backstage(15, 20),
            new Backstage(10, 49),
            new Backstage( 5, 49),
            new Conjured(3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}

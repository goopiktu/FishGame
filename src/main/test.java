package main;

import bag.Bag;
import materials.StoreItems;

import java.util.Collections;

import Locations.shop.Holgrehenn_Store;

public class test {
    public static void main(String[] args) {
        Holgrehenn_Store item = new Holgrehenn_Store();
        Bag bag = new Bag();
        bag.addItem(item.getMats().get(0));
        bag.addItem(item.getMats().get(0));
        bag.addItem(item.getMats().get(0));
        bag.addItem(item.getMats().get(1));
        bag.addItem(item.getMats().get(1));
        bag.addItem(item.getMats().get(0));
        bag.addItem(item.getMats().get(2));
        bag.addItem(item.getMats().get(2));

        int freqgold = Collections.frequency(bag.getMats(), new StoreItems("Gold", 750, "Holgrehenn Store", "Common"));
        int freqmajwat = Collections.frequency(bag.getMats(), new StoreItems("Majestic Water", 100, "Holgrehenn Store", "Common"));
        
        System.out.println(freqgold);

        System.out.println(freqmajwat);
    }
}
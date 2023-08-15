package main;

import org.junit.Before;
import org.junit.Test;

import bag.Bag;
import materials.*;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.Random;
// import bag.Bag;
// import materials.StoreItems;

// import java.util.Collections;

// import Locations.shop.Holgrehenn_Store;

public class test {

    private final Bag bag = new Bag();
    // private final Materials mat = new Materials();

    private StoreItems gold = new StoreItems("Gold", 750, "test", "Common");
    private StoreItems water = new StoreItems("Majestic Water", 100, "test", "Common");
    private StoreItems vinegar = new StoreItems("Wondrous Vinegar", 150, "test", "Common");
    private Bait basic_bait = new Bait("Magical Bait", 300, "test", "Common", 2);
    private Random rand = new Random();

    private int[] index = {0, 0, 0, 0};

    @Before 
    public void populateBag() {
        
        Materials[] mat = {gold, water, vinegar, basic_bait};
        for (int i = 0; i < this.index.length; i++) {
            this.index[i] = rand.nextInt(100) + 1;    
            System.out.println("index[" + i + "] = " + this.index[i]);
        }

        for (int i = 0; i < this.index.length; i++) {
            for (int j = 0; j < this.index[i]; j++) {
                bag.addItem(mat[i]);
            }
        }

    }

    @Test
    public void frequency_test_gold() {

        int freqGold = Collections.frequency(bag.getMats(), new StoreItems("Gold", 750, "test", "Common"));
            
        System.out.println("Frequency of gold: " + freqGold);
        System.out.println("Expected frequency: " + this.index[0]);
    
        assertEquals("They are equal", this.index[0], freqGold);
    }
    
    
    @Test
    public void frequency_test_water() {
        int freqWater = Collections.frequency(bag.getMats(), new StoreItems("Majestic Water", 100, "test", "Common"));
        
        System.out.println("Frequency of Water: " + freqWater);
        System.out.println("Expected frequency: " + this.index[1]);
        
        assertEquals("They are equal", this.index[1], freqWater);
    }
    
    @Test
    public void frequency_test_vinegar() {
        int freqVinegar = Collections.frequency(bag.getMats(), new StoreItems("Wondrous Vinegar", 150, "test", "Common"));
        
        System.out.println("Frequency of Vinegar: " + freqVinegar);
        System.out.println("Expected frequency: " + this.index[2]);
        
        assertEquals("They are equal", this.index[2], freqVinegar);
    }
    
    
    @Test
    public void frequency_test_bait() {
        int freqBait = Collections.frequency(bag.getMats(), new Bait("Magical Bait", 300, "test", "Common", 2));
        
        System.out.println("Frequency of Bait: " + freqBait);
        System.out.println("Expected frequency: " + this.index[3]);
        
        assertEquals("They are equal", this.index[3], freqBait);
    }
    
    // public static void main(String[] args) {
    //     Holgrehenn_Store item = new Holgrehenn_Store();
    //     Bag bag = new Bag();
    //     bag.addItem(item.getMats().get(0));
    //     bag.addItem(item.getMats().get(0));
    //     bag.addItem(item.getMats().get(0));
    //     bag.addItem(item.getMats().get(1));
    //     bag.addItem(item.getMats().get(1));
    //     bag.addItem(item.getMats().get(0));
    //     bag.addItem(item.getMats().get(2));
    //     bag.addItem(item.getMats().get(2));

    //     int freqgold = Collections.frequency(bag.getMats(), new StoreItems("Gold", 750, "Holgrehenn Store", "Common"));
    //     int freqmajwat = Collections.frequency(bag.getMats(), new StoreItems("Majestic Water", 100, "Holgrehenn Store", "Common"));
        
    //     System.out.println(freqgold);

    //     System.out.println(freqmajwat);
    // }
}
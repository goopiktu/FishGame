package main;

import items.Item;
import items.material.materials.Bait;
import items.material.materials.Fish;
import items.material.materials.StoreItems;

import java.util.ArrayList;

/**
 * ItemAtlas
 */
public class ItemAtlas {
    private ArrayList<Item> items;

    public ItemAtlas() {
        items = new ArrayList<>();
        initFishItems();
        initMarketItems();
        initBaitItems();
    }

    public void initFishItems() {
        // Dagupan Mangrove Forests
        items.add(new Fish("Mudskippers", 1000f, "Dagupan Mangrove Forests", "Rare"));
        items.add(new Fish("Bangus", 50f, "Dagupan Mangrove Forests", "Common"));

        // Galathea Deep
        items.add(new Fish("Mariana Snailfish", 1000f, "Galathea Deep", "Rare"));
        items.add(new Fish("Sardines", 40f, "Galathea Deep", "Common"));

        // Mindanao Current
        items.add(new Fish("Hillstream Loaches", 1000f, "Mindanao Current", "Rare"));
        items.add(new Fish("Tuna", 45f, "Mindanao Current", "Common"));

        // Taal Lake
        items.add(new Fish("Scaleless Blackfish", 1000f, "Taal Lake", "Rare"));
        items.add(new Fish("Tilapia", 35f, "Taal Lake", "Common"));

    }

    public void initMarketItems() {
        // Market
        items.add(new StoreItems("Gold", 750, "Holgrehenn Store", "Common"));
        items.add(new StoreItems("Majestic Water", 100, "Holgrehenn Store", "Common"));
        items.add(new StoreItems("Wondrous Vinegar", 150, "Holgrehenn Store", "Common"));

    }

    public void initBaitItems() {
        // Bait can be bought through market or maybe found? not sure yet.
        items.add(new Bait("Magical Bait", 300, "Holgrehenn Store", "Common", 2));
    }

    public void initPotionItems() {

    }

    public <T extends Item> T getItemByName(String name, Class<T> type) {
        for (Item item : this.items) {
            if (item.getName().equals(name)) {
                return type.cast(item);
            }
        }
        return null;
    }

    public void getItemByPrice() {
    }

    public void getItemByLocation() {
    }

    public void getItemByRareity() {
    }

}
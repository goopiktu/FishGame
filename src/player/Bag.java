package player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Map.Entry;

import items.Item;

public class Bag {

    private LinkedHashMap<Item, Integer> bag; // Item: key, Value: Qty
    private ArrayList<Item> items;
    private Item[] itemMapping;

    public Bag() {
        this.items = new ArrayList<Item>();
        this.bag = new LinkedHashMap<Item, Integer>();
    }

    // The whole list with duplicaiton
    public ArrayList<Item> getItems() {
        return items;
    }

    // The entire bad with no duplicaiton
    public LinkedHashMap<Item, Integer> getBag() {
        return bag;
    }

    // Get Item in bag by index
    public Item getItemByIndex(int i) {
        if (i < 0 && i > itemMapping.length) {
            return null;
        }
        return itemMapping[i];
    }

    // Set Items
    public void setMaterials(ArrayList<Item> item) {
        this.items = item;
        setBag(items);
    }

    // Remove from
    public void removeItem(Item item) {
        this.items.remove(item);
        // Adjust the bag directly
        if (this.bag.containsKey(item)) {
            int count = this.bag.get(item);
            if (count > 1) {
                this.bag.put(item, count - 1);
            } else {
                this.bag.remove(item); // Remove item if count goes to zero
            }
        }
        setItemMapping(); // Update the item mapping after removal
    }

    public void addItem(Item item) {
        this.items.add(item);
        setBag(items);
    }

    public boolean contains(Item item) {
        if (items.contains(item)) {
            return true;
        }
        return false;
    }

    public void setBag(ArrayList<Item> item) {
        // this makes it so that i know all the materials without duplicates
        this.bag.clear(); // Clear the existing map before recalculating

        Set<Item> uniqueItems = new LinkedHashSet<>(item);
        for (Item uniqueItem : uniqueItems) {
            int frequency = Collections.frequency(this.getItems(), uniqueItem);
            this.bag.put(uniqueItem, frequency);
        }
        setItemMapping(); // Update the item mapping after setting the bag
    }

    public void setItemMapping() {
        this.itemMapping = new Item[this.bag.size()];
        int counter = 0;
        for (Entry<Item, Integer> bag : this.bag.entrySet()) {
            this.itemMapping[counter] = bag.getKey();
            counter++;
        }
    }

    public void printBag() {
        String spacer = "Items";

        int i = 0;

        System.out.format("#==================================================#\n");
        System.out.format("||  Row  || %-30s || Qty ||\n", spacer);
        System.out.format("#==================================================#\n");

        for (Entry<Item, Integer> bag : this.bag.entrySet()) {
            System.out.format("||   %d   || %-30s || %2d  ||\n", i + 1, bag.getKey().getName(), bag.getValue());
            i++;

        }

        System.out.printf("#==================================================#\n");
    }
}

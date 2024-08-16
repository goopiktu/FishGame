package player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Map.Entry;

import items.Item;

public class Bag {

    private LinkedHashMap<Item, Integer> bag;
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

    public void setMaterials(ArrayList<Item> item) {
        this.items = item;
        setBag(items);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
        setBag(items);
    }

    public void removeItems(Item item, int i) {

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
        Set<Item> uniqueItems = new LinkedHashSet<Item>();
        uniqueItems.addAll(item);

        int size = uniqueItems.size();
        int frequency = 0;

        Item[] arrayUniqueItems = new Item[size];
        arrayUniqueItems = uniqueItems.toArray(arrayUniqueItems);

        for (int i = 0; i < size; i++) {
            frequency = Collections.frequency(this.getItems(), arrayUniqueItems[i]);
            this.bag.put(arrayUniqueItems[i], frequency);
        }
        setItemMapping();
    }

    public void setItemMapping() {
        this.itemMapping = new Item[this.bag.size()];
        int counter = 0;
        for (Entry<Item, Integer> bag : this.bag.entrySet()) {
            this.itemMapping[counter] = bag.getKey();
            counter++;
        }
        for (int i = 0; i < itemMapping.length; i++) {
            System.out.println("" + i + this.itemMapping[i]);
        }
    }

    public void printBag() {
        String spacer = "Items";
        int count = 1;

        System.out.format("#================================================#\n");
        System.out.format("|| Row || %-30s || Qty ||\n", spacer);
        System.out.format("#================================================#\n");
        for (Entry<Item, Integer> bag : this.bag.entrySet()) {
            // System.out.println(bag.getKey().getName() + " : " + bag.getValue());
            System.out.format("|| %2d  || %-30s || %2d  ||\n", count, bag.getKey().getName(), bag.getValue());
            count++;
        }
        System.out.printf("#================================================#\n");
    }
    // @Override
    // public String toString() {

    // }

    // need to make the bag a hashmap instead of a arraylist since
    // i need to count how many occurences there are for each item

    // protected String toString(){
    // return Integer.toString(addressNo);
    // }
    // public String toString() {

    // }

    // #######################################################
    // public void removefromBag(String name) {

    // for (Materials i : this.bag) {
    // if(i.getName().equals(name)) {
    // this.bag.remove(i);
    // return;
    // }
    // }
    // }

    // public boolean lookForItem (Materials name) {
    // for (int i = 0; i < bag.size(); i++) {
    // if(bag.get(i).getName().equals(name.getName()))
    // return true;
    // }
    // return false;
    // }

    // public ArrayList<Materials> getBag() {
    // return bag;
    // }

    // public void checkBag() {
    // Set<Materials> uniqueItems = new HashSet<>(bag);

    // int iteration = 0;
    // System.out.println("=======================================");
    // for (Materials item : uniqueItems) {
    // iteration++;
    // item_id.put(iteration, item);
    // checkBagString(iteration, item, bag);
    // }
    // if(iteration == 0)
    // System.out.println("EMPTY");
    // System.out.println("=======================================");

    // }

    // public void addItemToBag(Materials materials) {
    // bag.add(materials);
    // }

    // public void addItemsToBag(List<Materials> materials) {
    // bag.addAll(bag);
    // }

}

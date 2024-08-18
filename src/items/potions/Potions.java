package items.potions;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import player.Player;
import items.Item;
import items.material.Materials;
import main.ItemAtlas;

public abstract class Potions extends Item {

    // private String name;
    private ArrayList<Materials> recipe;
    private LinkedHashMap<Materials, Integer> uniqueRecipe;

    private ItemAtlas item;

    public Potions(String name) {
        super(name, 0);
        this.recipe = new ArrayList<Materials>();
        this.uniqueRecipe = new LinkedHashMap<Materials, Integer>();
    }

    public String getName() {
        return name;
    }

    public ItemAtlas getItemInAtlas() {
        return item;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Materials> getRecipe() {
        return recipe;
    }

    public void setRecipe(ArrayList<Materials> recipe) {
        this.recipe = recipe;
        setUniqueRecipe(recipe);
    }

    public void addRecipe(Materials mat) {
        this.recipe.add(mat);
        setUniqueRecipe(recipe);
    }

    public void setUniqueRecipe(ArrayList<Materials> materials) {

        // this makes it so that i know all the materials without duplicates
        Set<Materials> uniqueItems = new LinkedHashSet<Materials>();
        uniqueItems.addAll(materials);

        int size = uniqueItems.size();
        int frequency = 0;

        Materials[] arrayUniqueItems = new Materials[size];
        arrayUniqueItems = uniqueItems.toArray(arrayUniqueItems);

        for (int i = 0; i < size; i++) {
            frequency = Collections.frequency(this.getRecipe(), arrayUniqueItems[i]);
            this.uniqueRecipe.put(arrayUniqueItems[i], frequency);
        }
    }

    public void showRecipe(Player player) throws InterruptedException {

        int player_material_counter = 0;
        System.out.println("\nCrafting Recipe:");

        // Name Location Rareity Pricee
        String potionString = "| %-20s | %-3d | %-3d |\n";

        System.out.format(
                "+----------------------+---------------------------+----------------------+-----------------------+-----+-----+\n");
        System.out.format(
                "|  NAME                |  LOCATION                 |  RAREITY             |  PRICE                | INV | REQ |\n");
        System.out.format(
                "+----------------------+---------------------------+----------------------+-----------------------+-----+-----+\n");

        for (Entry<Materials, Integer> uniqueRecipe : this.uniqueRecipe.entrySet()) {
            // if (player.bag.contains(materials))
            // player_material_counter++;

            System.out.format(potionString, uniqueRecipe.getKey(), player_material_counter,
                    uniqueRecipe.getValue());

        }
        System.out.format(
                "+----------------------+---------------------------+----------------------+-----------------------+-----+-----+\n");
    }

    public float setPrice() {
        float val = 0;
        float increase = 0;
        for (int i = 0; i < this.getRecipe().size(); i++) {
            val += this.getRecipe().get(i).getPrice();
        }
        increase = (float) (val * 0.37);
        val += increase;
        return val;
    }

}
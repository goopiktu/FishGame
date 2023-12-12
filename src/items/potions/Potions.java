package items.potions;

import java.util.ArrayList;

import items.materials.Materials;
import player.Player;
import items.Item;


public abstract class Potions extends Item{

    // private String name;
    private ArrayList<Materials> recipe;

    public Potions(String name) {
        super(name, 0);
        this.recipe = new ArrayList<Materials>(); 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Materials> getRecipe() {
        return recipe;
    }

    public void setRecipe(ArrayList<Materials> recipe) {
        this.recipe = recipe;
    }

    public void addRecipe(Materials mat) {
        recipe.add(mat);
    } 

    public void showRecipe(Player player) {

        int recipe_counter = 0;
        int player_material_counter = 0;

        System.out.println("\nCrafting Recipe:");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        String s = String.format("+  %-20s\t%-5s\t\t%-26s\t%-20s+\n", "Name", "Price", "Location", "Rareity");        
      
        System.out.print(s);
        System.out.println("+\t\t\t\t\t\t\t\t\t\t\t    +");
        for (Materials materials : recipe) {
            if(player.bag.contains(materials)) 
                player_material_counter++;

            System.out.println("+  " + materials.toString()+ "+  " +  player_material_counter +"/"+ recipe_counter + "  +");

            
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        // \t \t \t
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

    @Override
    public void use() {
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }

    // public abstract void 
    
}
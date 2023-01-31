package potions;

import java.util.ArrayList;

import materials.Materials;



public class Potions {

    private String name;
    private ArrayList<Materials> recipe;

    public Potions(String name) {
        this.name = name;
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
    
}
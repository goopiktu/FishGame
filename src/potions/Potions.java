package potions;

import java.util.ArrayList;

import materials.Materials;



public class Potions extends Materials{

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

    public void showRecipe() {
        System.out.println("\nCrafting Recipe:");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        String s = String.format("+  %-20s\t%-5s\t\t%-26s\t%-20s+\n", "Name", "Price", "Location", "Rareity");        
      
        System.out.print(s);
        System.out.println("+\t\t\t\t\t\t\t\t\t\t\t    +");
        for (Materials materials : recipe) {
            System.out.println("+  " + materials.toString()+ "+");
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        // \t \t \t
    }

    public void setPrice() {
        double val = 0;
        double increase = 0;
        for (int i = 0; i < this.getRecipe().size(); i++) {
            val += this.getRecipe().get(i).getPrice();
        }
        increase = val * 0.37;
        val += increase;
        this.setPrice(val);
    }
    
}
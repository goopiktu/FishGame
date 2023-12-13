package items.material.materials;

import items.material.Materials;

public class Bait extends Materials {
    
    private int chance;
    
    
    public Bait(String name, float price, String location, String rareity, int chance) {
        super(name, price, location, rareity);
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
}

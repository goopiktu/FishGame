package Locations.fishingSpot;

import materials.Fish;

public class Galathea_Deep extends Fishing_Spot{
    public Galathea_Deep() {
        setName("Galathea Deep");
        addFish(new Fish("Mariana Snailfish", 1000f, "Galathea Deep", "Rare"));
        addFish(new Fish("Sardines", 40f, "Galathea Deep", "Common"));
    }
}
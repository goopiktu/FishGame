package Locations.fishingSpot;

import materials.Fish;

public class Dagupan_Mangrove_Forests extends Fishing_Spot{
    public Dagupan_Mangrove_Forests() {
        setName("Dagupan Mangrove Forests");
        addFish(new Fish("Mudskippers", 1000f, "Dagupan Mangrove Forests", "Rare"));
        addFish(new Fish("Bangus", 50f, "Dagupan Mangrove Forests", "Common"));
    }
}

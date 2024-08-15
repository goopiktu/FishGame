package Locations.fishingSpot.fishingSpots;

import Locations.fishingSpot.Fishing_Spot;
import items.material.materials.Fish;
import main.ItemAtlas;

public class Dagupan_Mangrove_Forests extends Fishing_Spot {
    public Dagupan_Mangrove_Forests(ItemAtlas item) {
        setName("Dagupan Mangrove Forests");
        addFish(item.getItemByName("Mudskippers", Fish.class));
        addFish(item.getItemByName("Bangus", Fish.class));
    }
}

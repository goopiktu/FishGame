package Locations.fishingSpot.fishingSpots;

import Locations.fishingSpot.Fishing_Spot;
import items.material.materials.Fish;
import main.ItemAtlas;

public class Galathea_Deep extends Fishing_Spot {
    public Galathea_Deep(ItemAtlas item) {
        setName("Galathea Deep");
        // Mariana Snailfiish
        // Galathea Deep
        addFish(item.getItemByName("Mariana Snailfish", Fish.class));
        addFish(item.getItemByName("Sardines", Fish.class));
    }
}
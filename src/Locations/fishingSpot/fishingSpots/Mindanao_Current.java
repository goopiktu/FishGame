package Locations.fishingSpot.fishingSpots;

import Locations.fishingSpot.Fishing_Spot;
import items.material.materials.Fish;
import main.ItemAtlas;

/**
 * Mindanao_Current
 */
public class Mindanao_Current extends Fishing_Spot {

    public Mindanao_Current(ItemAtlas item) {
        setName("Mindanao Current");

        addFish(item.getItemByName("Hillstream Loaches", Fish.class));
        addFish(item.getItemByName("Tuna", Fish.class));
    }
}
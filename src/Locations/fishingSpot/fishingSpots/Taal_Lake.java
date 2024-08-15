package Locations.fishingSpot.fishingSpots;

import Locations.fishingSpot.Fishing_Spot;
import items.material.materials.Fish;
import main.ItemAtlas;

public class Taal_Lake extends Fishing_Spot {

    public Taal_Lake(ItemAtlas item) {
        setName("Taal Lake");
        addFish(item.getItemByName("Scaleless Blackfish", Fish.class));
        addFish(item.getItemByName("Tilapia", Fish.class));
    }

}

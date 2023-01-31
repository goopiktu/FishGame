package Locations.fishingSpot;

import materials.Fish;

public class Taal_Lake extends Fishing_Spot {

    public Taal_Lake() {
        setName("Taal Lake");
        addFish(new Fish("Scaleless Blackfish", 1000f, "Taal Lake", 0.10));
        addFish(new Fish("Tilapia", 35f, "Taal Lake", 0.90));
    }
    
}

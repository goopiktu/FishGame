package Locations.fishingSpot;

import materials.Fish;

/**
 * Mindanao_Current
 */
public class Mindanao_Current extends Fishing_Spot{

    public Mindanao_Current() {
        setName("Mindanao Current");
        addFish(new Fish("Hillstream Loaches", 1000f, "Mindanao Current", 0.10));
        addFish(new Fish("Tuna", 45f, "Mindanao Current", 0.90));
    }
}
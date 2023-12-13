package items.potions.potion_types;

import Locations.fishingSpot.fishingSpots.Taal_Lake;
import Locations.shop.Shop;
import items.material.materials.Fish;
import items.material.materials.StoreItems;
import items.potions.Potions;

/**
 * Fire_Potion
 */
public class Fire_Potion extends Potions {


    public Fire_Potion() {
        super("Fire Potion");
        addRecipe(new Fish("Scaleless Blackfish", 1000f, "Taal Lake", "Rare"));
        addRecipe(new StoreItems("Gold", 750, "Shop", "Common"));
        addRecipe(new StoreItems("Majestic Water", 100, "Shop", "Common"));
        addRecipe(new StoreItems("Wondrous Vinegar", 150, "Shop", "Common"));
        setPrice();
    }

    public Fire_Potion(String name, Taal_Lake taal, Shop shop) {
        super(name);
        addRecipe(taal.getFishes().get(0));
        addRecipe(shop.getMats().get(0));
        addRecipe(shop.getMats().get(1));
        addRecipe(shop.getMats().get(2));
        setPrice();

    }

    
}
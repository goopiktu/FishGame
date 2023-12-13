package items.potions.potion_types;

import Locations.fishingSpot.fishingSpots.Galathea_Deep;
import Locations.shop.Shop;
import items.material.materials.Fish;
import items.material.materials.StoreItems;
import items.potions.Potions;

public class Water_Potion extends Potions{

    public Water_Potion() {
        super("Water Potion");
        addRecipe(new Fish("Mariana Snailfish", 1000f, "Galathea Deep", "Rare"));
        addRecipe(new StoreItems("Gold", 750, "Shop", "Common"));
        addRecipe(new StoreItems("Majestic Water", 100, "Shop", "Common"));
        addRecipe(new StoreItems("Wondrous Vinegar", 150, "Shop", "Common"));
        setPrice();
    }

    public Water_Potion(String name, Galathea_Deep galathea, Shop shop) {
        super(name);
        addRecipe(galathea.getFishes().get(0));
        addRecipe(shop.getMats().get(0));
        addRecipe(shop.getMats().get(1));
        addRecipe(shop.getMats().get(2));
        setPrice();
    }
    
}

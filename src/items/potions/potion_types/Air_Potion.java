package items.potions.potion_types;

import Locations.fishingSpot.Fishing_Spot;
import Locations.shop.Shop;
import items.materials.Fish;
import items.materials.StoreItems;
import items.potions.Potions;

public class Air_Potion extends Potions{


    public Air_Potion(String name, Fishing_Spot fishing_Spot, Shop shop) {
        super(name);
        addRecipe(fishing_Spot.getFishes().get(0));
        addRecipe(shop.getMats().get(0));
        addRecipe(shop.getMats().get(1));
        addRecipe(shop.getMats().get(2));
        setPrice();
    }

    public Air_Potion() {
        super("Air Potion");
        addRecipe(new Fish("Hillstream Loaches", 1000f, "Mindanao Current", "Rare"));
        addRecipe(new StoreItems("Gold", 750, "Shop", "Common"));
        addRecipe(new StoreItems("Majestic Water", 100, "Shop", "Common"));
        addRecipe(new StoreItems("Wondrous Vinegar", 150, "Shop", "Common"));
        setPrice();
    }

    

}
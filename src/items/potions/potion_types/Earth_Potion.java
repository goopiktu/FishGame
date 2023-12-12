package items.potions.potion_types;

import Locations.fishingSpot.Dagupan_Mangrove_Forests;
import Locations.shop.Shop;
import items.materials.Fish;
import items.materials.StoreItems;
import items.potions.Potions;

public class Earth_Potion extends Potions{

    public Earth_Potion() {
        super("Earth Potion");
        addRecipe(new Fish("Mudskippers", 1000f, "Dagupan Mangrove Forests", "Rare"));
        addRecipe(new StoreItems("Gold", 750, "Shop", "Common"));
        addRecipe(new StoreItems("Majestic Water", 100, "Shop", "Common"));
        addRecipe(new StoreItems("Wondrous Vinegar", 150, "Shop", "Common"));
        setPrice();
    }



    public Earth_Potion(String name, Dagupan_Mangrove_Forests mangrove, Shop shop) {
        super(name);
        addRecipe(mangrove.getFishes().get(0));
        addRecipe(shop.getMats().get(0));
        addRecipe(shop.getMats().get(1));
        addRecipe(shop.getMats().get(2));
        setPrice();
    }

}

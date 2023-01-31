package potions;

import Locations.fishingSpot.Dagupan_Mangrove_Forests;
import Locations.shop.Holgrehenn_Store;

public class Earth_Potion extends Potions{

    public Earth_Potion(String name, Dagupan_Mangrove_Forests mangrove, Holgrehenn_Store shop) {
        super(name);
        addRecipe(mangrove.getFishes().get(0));
        addRecipe(shop.getMats().get(0));
        addRecipe(shop.getMats().get(1));
        addRecipe(shop.getMats().get(2));
    }

}

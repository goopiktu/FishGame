package potions;

import Locations.fishingSpot.Galathea_Deep;
import Locations.shop.Holgrehenn_Store;

public class Water_Potion extends Potions{

    public Water_Potion(String name, Galathea_Deep galathea, Holgrehenn_Store shop) {
        super(name);
        addRecipe(galathea.getFishes().get(0));
        addRecipe(shop.getMats().get(0));
        addRecipe(shop.getMats().get(1));
        addRecipe(shop.getMats().get(2));
    }
    
}

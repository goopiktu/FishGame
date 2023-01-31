package potions;

import Locations.fishingSpot.Taal_Lake;
import Locations.shop.Holgrehenn_Store;

/**
 * Fire_Potion
 */
public class Fire_Potion extends Potions {

    public Fire_Potion(String name, Taal_Lake taal, Holgrehenn_Store shop) {
        super(name);
        addRecipe(taal.getFishes().get(0));
        addRecipe(shop.getMats().get(0));
        addRecipe(shop.getMats().get(1));
        addRecipe(shop.getMats().get(2));

    }

    
}
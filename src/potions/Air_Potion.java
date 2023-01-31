package potions;

import Locations.fishingSpot.Mindanao_Current;
import Locations.shop.Holgrehenn_Store;

/**
 * Air_Potion
 */
public class Air_Potion extends Potions{

    public Air_Potion(String name, Mindanao_Current mindanao, Holgrehenn_Store shop) {
        super(name);
        addRecipe(mindanao.getFishes().get(0));
        addRecipe(shop.getMats().get(0));
        addRecipe(shop.getMats().get(1));
        addRecipe(shop.getMats().get(2));
    }

}
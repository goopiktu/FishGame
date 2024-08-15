package items.potions.potion_types;

import items.material.materials.Fish;
import items.material.materials.StoreItems;
import items.potions.Potions;
import main.ItemAtlas;

/**
 * Fire_Potion
 */
public class Fire_Potion extends Potions {
    public Fire_Potion(ItemAtlas item) {
        super("Fire Potion");
        addRecipe(item.getItemByName("Scaleless Blackfish", Fish.class));
        addRecipe(item.getItemByName("Gold", StoreItems.class));
        addRecipe(item.getItemByName("Majestic Water", StoreItems.class));
        addRecipe(item.getItemByName("Wondrous Vinegar", StoreItems.class));
        setPrice();
    }

}
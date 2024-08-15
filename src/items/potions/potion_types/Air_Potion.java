package items.potions.potion_types;

import items.material.materials.Fish;
import items.material.materials.StoreItems;
import items.potions.Potions;
import main.ItemAtlas;

public class Air_Potion extends Potions {
    public Air_Potion(ItemAtlas item) {
        super("Air Potion");
        addRecipe(item.getItemByName("Hillstream Loaches", Fish.class));
        addRecipe(item.getItemByName("Gold", StoreItems.class));
        addRecipe(item.getItemByName("Majestic Water", StoreItems.class));
        addRecipe(item.getItemByName("Wondrous Vinegar", StoreItems.class));
        setPrice();
    }
}
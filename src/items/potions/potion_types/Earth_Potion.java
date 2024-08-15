package items.potions.potion_types;

import items.material.materials.Fish;
import items.material.materials.StoreItems;
import items.potions.Potions;
import main.ItemAtlas;

public class Earth_Potion extends Potions {
    public Earth_Potion(ItemAtlas item) {
        super("Earth Potion");
        addRecipe(item.getItemByName("Mudskippers", Fish.class));
        addRecipe(item.getItemByName("Gold", StoreItems.class));
        addRecipe(item.getItemByName("Majestic Water", StoreItems.class));
        addRecipe(item.getItemByName("Wondrous Vinegar", StoreItems.class));
        setPrice();
    }

}

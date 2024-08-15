package items.potions.potion_types;

import items.material.materials.Fish;
import items.material.materials.StoreItems;
import items.potions.Potions;
import main.ItemAtlas;

public class Water_Potion extends Potions {
    public Water_Potion(ItemAtlas item) {
        super("Water Potion");
        addRecipe(item.getItemByName("Mariana Snailfish", Fish.class));
        addRecipe(item.getItemByName("Gold", StoreItems.class));
        addRecipe(item.getItemByName("Majestic Water", StoreItems.class));
        addRecipe(item.getItemByName("Wondrous Vinegar", StoreItems.class));
        setPrice();
    }

}

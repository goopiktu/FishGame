package Locations.shop.shops;

import Locations.shop.Shop;
import items.material.materials.Bait;
import items.material.materials.StoreItems;
import main.ItemAtlas;

public class Holgrehenn_Store extends Shop {
    public Holgrehenn_Store(ItemAtlas item) {
        setName("Holgrehenn Store");

        addMats(item.getItemByName("Gold", StoreItems.class));
        addMats(item.getItemByName("Majestic Water", StoreItems.class));
        addMats(item.getItemByName("Wondrous Vinegar", StoreItems.class));
        addMats(item.getItemByName("Magical Bait", Bait.class));
    }

}

package Locations.shop;


import materials.Bait;
import materials.StoreItems;

public class Holgrehenn_Store extends Shop{
    public Holgrehenn_Store() {
        setName("Holgrehenn Store");  

        addMats(new StoreItems("Gold", 750, this.getName(), "Common"));
        addMats(new StoreItems("Majestic Water", 100, this.getName(), "Common"));
        addMats(new StoreItems("Wondrous Vinegar", 150, this.getName(), "Common"));
        addMats(new Bait("Magical Bait", 300, this.getName(), "Common", 2));

    }


    
}

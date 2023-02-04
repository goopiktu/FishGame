package Locations.shop;


import materials.Materials;

public class Holgrehenn_Store extends Shop{
    public Holgrehenn_Store() {
        setName("Holgrehenn Store");  

        addMats(new Materials("Gold", 750));
        addMats(new Materials("Majestic Water", 100));
        addMats(new Materials("Wondrous Vinegar", 150));
        addMats(new Materials("Magical Bait", 300));

    }


    
}

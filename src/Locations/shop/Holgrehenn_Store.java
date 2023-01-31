package Locations.shop;


import materials.Materials;

public class Holgrehenn_Store extends Shop{
    public Holgrehenn_Store() {
        setName("Holgrehenn Store");  

        addMats(new Materials("Gold", 750, "Holgrehenn Store", 0));
        addMats(new Materials("Majestic Water", 100, "Holgrehenn Store", 0));
        addMats(new Materials("Wondrous Vinegar", 150, "Holgrehenn Store", 0));
        addMats(new Materials("Magical Bait", 300, "Holgrehenn Store", 0));

    }


    
}

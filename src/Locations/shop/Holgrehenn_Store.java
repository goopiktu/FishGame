package Locations.shop;


import materials.Materials;

public class Holgrehenn_Store extends Shop{
    public Holgrehenn_Store() {
        setName("Holgrehenn Store");  

        addMats(new Materials("Gold", 750, this.getName(), "Common"));
        addMats(new Materials("Majestic Water", 100, this.getName(), "Common"));
        addMats(new Materials("Wondrous Vinegar", 150, this.getName(), "Common"));
        addMats(new Materials("Magical Bait", 300, this.getName(), "Common"));

    }


    
}

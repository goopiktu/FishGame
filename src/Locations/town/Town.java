package Locations.town;

public class Town {
    private String name;
    
    public Town() {
        name = "Geffen Town";
    }

    public Town(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

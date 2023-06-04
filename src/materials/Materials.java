package materials;

public class Materials {
    
    private String name;
    private double price;
    private String location;
    private String rareity;

    
    
    public Materials() {
        name = "Unknown";
        price = 0f;
        location = "Unknown";
        rareity = "Unknown";
    }

    public Materials(String name, double price, String location, String rareity) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.rareity = rareity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRareity() {
        return rareity;
    }

    public void setRareity(String rareity) {
        this.rareity = rareity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
		String s = String.format("%-20s\t%,.2f\t\t%-26s\t%-20s", 
        this.getName(), this.getPrice(), this.getLocation(), this.getRareity());
		return s;
	}
   //Name: Price: Location: Rareity: 
}

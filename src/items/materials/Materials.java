package items.materials;

import items.Item;

public abstract class Materials extends Item{
    
    // private String name;
    // private double price;
    private String location;
    private String rareity;

    public Materials(String name, float price, String location, String rareity) {
        super(name, price);
        this.location = location;
        this.rareity = rareity;
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

   @Override 
   public boolean equals(Object o) {
        if(o == this)
            return true;
        if (!(o instanceof Materials)) { 
            return false; 
        } 

        Materials c = (Materials) o;
            
        return Double.compare(c.price, this.price) == 0 &&
                              c.name == this.name &&
                              c.location == this.location &&
                              c.rareity == this.rareity;
               

   }

}

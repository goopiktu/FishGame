package materials;

public class Fish extends Materials{

    private String location;
    private String rareity;


    public Fish(String name, double price, String location, String rareity) {
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

    @Override
    public String toString() {
        
        String s = String.format("Name: %-20s\tPrice: %,.2f\t\tLocation: %-26s\tRareity: %-20s", 
        this.getName(), this.getPrice(), this.location, this.rareity);
        return s;
    }

    
}

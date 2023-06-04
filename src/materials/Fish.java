package materials;

public class Fish extends Materials{

    public Fish(String name, double price, String location, String rareity) {
        super(name, price, location, rareity);
    }

    @Override
    public String toString() {
        String s = String.format("%-20s\t%,.2f\t%-26s\t%-20s", 
        this.getName(), this.getPrice(), this.getLocation(), this.getRareity());
        return s;
    }
    // Name: Price: Location: Rareity: 
    
}

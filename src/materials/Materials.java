package materials;

public class Materials {
    
    private String name;
    private double price;
    
    
    public Materials() {
        name = "Unknown";
        price = 0f;
    }

    public Materials(String name, double price) {
        this.name = name;
        this.price = price;
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

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString() {
		
		String s = String.format("%-20s\tPrice: %,.2f\t", this.name, this.price);
		return s;
	}
   
}

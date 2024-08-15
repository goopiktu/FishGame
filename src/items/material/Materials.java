package items.material;

import items.Item;
import java.util.Objects;

public abstract class Materials extends Item {

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
        // | %-20s | %-20s | %-20s | %-7d |
        String s = String.format("%-20s | %-25s | %-20s | %20.2f ",
                this.getName(), this.getLocation(), this.getRareity(), this.getPrice());
        return s;
    }

    // Name: Price: Location: Rareity:
    //
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Materials materials = (Materials) o;
        return Float.compare(materials.getPrice(), this.getPrice()) == 0 &&
                Objects.equals(this.getName(), materials.getName()) &&
                Objects.equals(location, materials.location) &&
                Objects.equals(rareity, materials.rareity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), location, rareity);
    }

}

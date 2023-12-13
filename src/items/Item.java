package items;

import items.material.Materials;

public abstract class Item {
    protected String name;
    protected float price;

    public Item(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
            if(o == this)
                return true;
            if (!(o instanceof Materials)) { 
                return false; 
            } 

            Materials c = (Materials) o;
                
            return Double.compare(c.price, this.price) == 0 &&
                                  c.name == this.name;
                

    }
}

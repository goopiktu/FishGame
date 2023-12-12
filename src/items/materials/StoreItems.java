package items.materials;

public class StoreItems extends Materials {
    public StoreItems(String name, float price, String location, String rareity) {
        super(name, price, location, rareity);
    }

    @Override
    public void use() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}

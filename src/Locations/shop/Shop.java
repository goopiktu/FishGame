package Locations.shop;
import java.util.ArrayList;

import items.material.Materials;

public class Shop {
    private String name;
    private ArrayList<Materials> mats;
    
    public Shop(){
        name = "";
        mats = new ArrayList<Materials>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Materials> getMats() {
        return mats;
    }

    public void setAllMats(ArrayList<Materials> mats) {
        this.mats = mats;
    }

    public void addAllMats(ArrayList<Materials> mats) {
        this.mats.addAll(mats);
    }

    public void addMats(Materials mats) {
        this.mats.add(mats);
    }

    public void showShop() {
        int count = 1;
        for (Materials i : this.mats) {
            System.out.println("[" + count + "] " + i);
            count++;
        }
    }

    public int lookForItem (String name) {
		for (int i = 0; i < mats.size(); i++) {
            if(mats.get(i).getName().equals(name))
                return i;
        }
        return -1;
	}
    
    
}

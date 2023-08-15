package bag;

import java.util.ArrayList;
import java.util.Collections;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import materials.Materials;

public class Bag {
    private LinkedHashMap<Materials, Integer> bag;
    private ArrayList<Materials> mats;

    public Bag() {
        this.mats = new ArrayList<Materials>();
        this.bag = new LinkedHashMap<Materials, Integer>();
    }

    public ArrayList<Materials> getMats() {
        return mats;
    }

    public LinkedHashMap<Materials, Integer> getBag() {
        return bag;
    }

    public void setMaterials(ArrayList<Materials> mats) {
        this.mats = mats;
        setBag(this.mats);
    }

    public void removeItem(Materials item) {
        mats.remove(item);
        setBag(mats);
    }

    public void addItem(Materials item) {
        mats.add(item);
        setBag(mats);
    }

    public boolean contains(Materials item) {
        if(mats.contains(item)) {
            return true;
        }
        return false;
    }


    public void setBag(ArrayList<Materials> mats)  {
        
        // this makes it so that i know all the materials without duplicates
        Set<Materials> uniqueItems = new LinkedHashSet<Materials>();
        uniqueItems.addAll(mats);

        int size = uniqueItems.size();
        int frequency = 0;

        Materials[] arrayUniqueItems = new Materials[size];
        arrayUniqueItems = uniqueItems.toArray(arrayUniqueItems);

        for (int i = 0; i < size; i++) {
            frequency = Collections.frequency(this.getMats(), arrayUniqueItems[i]);
            System.out.println(frequency);
            this.bag.put(arrayUniqueItems[i], frequency);
        }
    }
    
    public void printBag() {
        String spacer = "Items";
        System.out.printf("+=========================================+\n");
        System.out.printf( "|| %-33s Qty ||\n", spacer);
        for (Map.Entry<Materials, Integer>bag: this.bag.entrySet()) {
            // System.out.println(bag.getKey().getName() + " : " + bag.getValue());
            
            System.out.printf("|| %-35s%d  ||\n", bag.getKey().getName(), bag.getValue());
        }
        System.out.printf("+=========================================+\n");
    }
    // @Override
    // public String toString() {
        
    // }

    // need to make the bag a hashmap instead of a arraylist since 
    // i need to count how many occurences there are for each item

    // protected String toString(){
    //     return Integer.toString(addressNo);
    // }
    // public String toString() {
        
    // }

    //#######################################################
    // public void removefromBag(String name) {

	// 	for (Materials i : this.bag) {
	// 		if(i.getName().equals(name)) {
	// 			this.bag.remove(i);
	// 			return;
	// 		}
	// 	}	
	// }

	// public boolean lookForItem (Materials name) {
	// 	for (int i = 0; i < bag.size(); i++) {
    //         if(bag.get(i).getName().equals(name.getName()))
    //             return true;
    //     }
    //     return false;
	// }


    // public ArrayList<Materials> getBag() {	
	// 	return bag;
	// }

	// public void checkBag() {
	// 	Set<Materials> uniqueItems = new HashSet<>(bag);
		
	// 	int iteration = 0;
	// 	System.out.println("=======================================");
	// 	for (Materials item : uniqueItems) {
	// 		iteration++;	
	// 		item_id.put(iteration, item);
	// 		checkBagString(iteration, item, bag);	
	// 	}
	// 	if(iteration == 0)
	// 		System.out.println("EMPTY");
	// 	System.out.println("=======================================");
		
	// }

	// public void addItemToBag(Materials materials) {
	// 	bag.add(materials);
	// }

	// public void addItemsToBag(List<Materials> materials) {
	// 	bag.addAll(bag);
	// }
    
}

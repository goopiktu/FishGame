package player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import Locations.fishingSpot.Fishing_Spot;
import Locations.shop.Holgrehenn_Store;
import materials.Materials;
import potions.Potions;


public class Player extends playerString{
	
	private String name;
	private double money;
	private String playerLocation;
	private ArrayList<Materials> bag;
	private HashMap<Integer, Materials> item_id;

	private boolean bait;
 	
	
	public Player(String name) {
		this.name = name;
		money = 3000f;
		playerLocation = "Geffen Town";
		bag = new ArrayList<Materials>();
		bait = false;
		item_id = new HashMap<>();
	}

	
	public HashMap<Integer, Materials> getItem_id() {
		return item_id;
	}

	public boolean getBait() {
		return bait;
	}

	public void setbait(boolean bait) {
		this.bait = bait;
	}

	
	public String getPlayerLocation() {
		return playerLocation;
	}

	public void setPlayerLocation(String playerLocation) {
		this.playerLocation = playerLocation;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public ArrayList<Materials> getBag() {	
		return bag;
	}

	public void checkBag() {
		Set<Materials> uniqueItems = new HashSet<>(bag);
		
		int iteration = 0;

		for (Materials item : uniqueItems) {
			iteration++;	
			item_id.put(iteration, item);
			checkBagString(iteration, item, bag);	
		}
		
	}

	public void addItemToBag(Materials materials) {
		bag.add(materials);
	}

	public void addItemsToBag(List<Materials> materials) {
		bag.addAll(bag);
	}

	
	public void status() {
		statusString(name, playerLocation, money);
	}


	public void catchFish(Player pl, Fishing_Spot f) {
		
		Random rand = new Random();
		double chance = rand.nextInt(10) + 1;
		// 1 2 3 4 5 6 7 8 9 10 
		// [1 2 3 4 5 6 7 8 9][10] *No magical bait
		// [1 2 3 4 5 6 7][8 9 10] *With magical bait  
		int chanceCommon = 9;

		if(this.getBait()) {
			chanceCommon -= 2;
		} 
		
		if (chance <= chanceCommon) {
			pl.addItemToBag(f.getFishes().get(1));
			fishCaughtCommonString(f);
		}
		else {
			pl.addItemToBag(f.getFishes().get(0));
			fishCaughtRareString(f);
		}
		this.setbait(false);	
	}

	public void useBait() {
	
		if (this.lookForItem("Magical Bait")){
			this.removefromBag("Magical Bait");
			this.setbait(true);
		} else {
			this.setbait(false);	
		}											
	}

	public boolean checkItem(Materials material) {
		if(this.getBag().contains(material)){
			return true;
		}
		return false;
	}
	
	public void buy(Materials materials, Player player, Holgrehenn_Store shop, int qty) {
		if (! player.playerLocation.equals(shop.getName()) || player.getMoney() < materials.getPrice())
			return;
		subMoney(materials.getPrice() * qty);  
		addMultiItemsToBag(materials , qty);
	}

	public void addMultiItemsToBag(Materials materials, int i) {
		for (int j = 0; j < i; j++) {
			this.bag.add(materials);	
		}
	}
	

	private void subMoney(double money) {
		this.money -= money;
	}


	public void sell(Materials materials, Player player, Holgrehenn_Store shop, int qty) {
		
		
		if (! player.playerLocation.equals(shop.getName()))
			return;
		
		removeItemsFromBag(materials, qty, player);

	}

	public void addMoney(double money){
		this.money += money;
	}

	public void removeItemsFromBag(Materials materials, int qty, Player player) {
		for (int i = 0; i < qty; i++) {
			addMoney(materials.getPrice());
			removefromBag(materials.getName());
		}
	}

	public void removefromBag(String name) {

		for (Materials i : this.bag) {
			if(i.getName().equals(name)) {
				this.bag.remove(i);
				return;
			}
		}	
	}

	public boolean lookForItem (String name) {
		for (int i = 0; i < bag.size(); i++) {
            if(bag.get(i).getName().equals(name))
                return true;
        }
        return false;
	}


	public void craftPotion(Potions potion) {
		boolean materials = true;
		for (int i = 0; i < potion.getRecipe().size(); i++) {
			materials = checkItem(potion.getRecipe().get(i));
		}
		if(materials) {
			for (int i = 0; i < potion.getRecipe().size(); i++) {
				removefromBag(potion.getRecipe().get(i).getName());
			}
			craftPotionString(potion);
		}
	}
	
	
	
	
	
}

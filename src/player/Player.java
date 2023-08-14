package player;


import java.util.HashMap;

import java.util.Random;

import Locations.fishingSpot.Fishing_Spot;
import Locations.shop.Holgrehenn_Store;
import materials.Materials;
import potions.Potions;
import bag.Bag;


public class Player extends playerString{
	
	private String name;
	private double money;
	private String playerLocation;
	public Bag bag;
	private HashMap<Integer, Materials> item_id;

	// private boolean bait;
 	
	
	public Player(String name) {
		this.name = name;
		money = 0f;
		playerLocation = "Geffen Town";
		bag = new Bag();
		// bait = false;
		item_id = new HashMap<>();
	}

	
	public HashMap<Integer, Materials> getItem_id() {
		return item_id;
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

		// if(useBait(pl.bag.contains())) {
		// 	chanceCommon -= 2;
		// } 
		
		if (chance <= chanceCommon) {
			pl.bag.addItem(f.getFishes().get(1));
			fishCaughtCommonString(f);
		}
		else {
			pl.bag.addItem(f.getFishes().get(0));
			fishCaughtRareString(f);
		}	
	}


	/// change the bait stuff it looks so bad 
	public boolean useBait(Materials bait) {
		
		if (checkItem(bait)){
			this.bag.removeItem(bait);
			System.out.println("^using bait^");
			return true;
		} else {	
			System.out.println("^go to the shop to purchase some bait^");
			return false;
		}											
	}

	public boolean checkItem(Materials material) {
		if(this.bag.contains(material)){
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
			this.bag.addItem(materials);	
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
			player.bag.removeItem(materials);
		}
	}

	public void craftPotion(Potions potion) {
		boolean materials = true;
		for (int i = 0; i < potion.getRecipe().size(); i++) {
			materials = checkItem(potion.getRecipe().get(i));
			// System.out.println(materials);
			if(!materials) 
				break;
		}
		if(materials) {
			for (int i = 0; i < potion.getRecipe().size(); i++) {
				this.bag.removeItem(potion.getRecipe().get(i));
			}
			craftPotionString(potion);
			this.bag.addItem(potion);
		}
		else {
			System.out.println("not enough items to craft potion");
		}
	}
	
	
	
	
	
}

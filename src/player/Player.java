package player;

import java.util.ArrayList;

import java.util.HashSet;

import java.util.Random;
import java.util.Set;

import Locations.fishingSpot.Fishing_Spot;
import Locations.shop.Holgrehenn_Store;
import mainMenu.Atlas;
import materials.Materials;


public class Player extends playerString{
	
	private String name;
	private double money;
	private String playerLocation;
	private ArrayList<Materials> bag;
	
 	
	
	public Player(String name) {
		this.name = name;
		money = 0f;
		playerLocation = "Geffen Town";
		bag = new ArrayList<Materials>();
		
	}
	

	public Player(String name, double money, String playerLocation){
		this.name = name;
		this.money = money;
		this.playerLocation = playerLocation;
		this.bag = new ArrayList<Materials>();
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
		int count = 1;
		Set<Materials> st = new HashSet<Materials>(bag);
		for (Materials m : st) {
			checkBagString(count, m, bag);
			count++;	
		}
		count = 0;
	}

	public void addItemsToBag(Materials materials) {
		this.bag.add(materials);
	}

	
	public void status() {
		statusString(name, playerLocation, money);
	}

	// catch fish isnt right i have to think of a way to use the rareity var
	public void catchFish(Player pl, Fishing_Spot f, Boolean bait) {
		
		Random rand = new Random();
		double chance = rand.nextInt(10) + 1;
		// 1 2 3 4 5 6 7 8 9 10 
		// [1 2 3 4 5 6 7 8 9][10] *No magical bait
		// [1 2 3 4 5 6 7][8 9 10] *With magical bait  
		int chanceCommon = 9;

		if(bait) {
			chanceCommon -= 2;
		} 
		
		if (chance <= chanceCommon) {
			pl.addItemsToBag(f.getFishes().get(1));
			fishCaughtCommonString(f);
		}
		else {
			pl.addItemsToBag(f.getFishes().get(0));
			fishCaughtRareString(f);
		}
		    
	}

	public boolean useBait(Player player, Atlas atlas) {
		int i = atlas.getIndexMat("Magical Bait");

		if (player.checkItem(atlas.getAtlas().get(i))){
			player.bag.remove(atlas.getAtlas().get(i));
			return true;
		}										
		return false;		
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
		subMoney(materials.getPrice());  
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
			removefromBag(materials.getName(), player);
		}
	}

	public void removefromBag(String name, Player player) {

		for (Materials i : player.bag) {
			if(i.getName().equals(name)) {
				player.bag.remove(i);
				return;
			}
		}	
	}

	public int lookForItem (String name) {
		for (int i = 0; i < bag.size(); i++) {
            if(bag.get(i).getName().equals(name))
                return i;
        }
        return -1;
	}


	public void craftPotion() {



	}
	
	
	
	
	
}

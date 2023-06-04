package mainMenu;

import Locations.fishingSpot.*;
import Locations.shop.Holgrehenn_Store;
import main.Game;
import player.Player;


public class MainMenu {
	

	public MainMenu(Game game) {
		start(game);
	}
	
	public void start(Game game) {
		System.out.println("Welcome Adventurer! What is your name? ");
		String name = Game.scStr();
		Player player = new Player(name);
		Choices(player, game);
	}

	public void Choices(Player player, Game game) {
		while(game.getkeepRunning()) {
				player.status();
			if (player.getPlayerLocation().equals(game.getGeffenTown().getName())) {
				System.out.println("[1] Craft Potion");
			}
			else
				System.out.println("[1] Geffen Town");
			System.out.println("[2] Holgrehenn Store");
			System.out.println("[3] Taal Lake");
			System.out.println("[4] Galathea Deep");
			System.out.println("[5] Dagupan Mangrove Forests");
			System.out.println("[6] Mindanao Current");
			System.out.println("[7] Bag");
			System.out.println("[8] Exit.");
			

			//System.out.println("You're in " + player.getPlayerLocation());

			int input = Game.scInt();
			Game.scStr();
			if (player.getPlayerLocation().equals(game.getGeffenTown().getName()) && input == 1) {
				craftChoice(player, game);
			} else 
				mainMenu(player, input, game);
				
		}
	}


	private void craftChoice(Player player, Game game) {
		
		System.out.println("[1] Air Potion");
		System.out.println("[2] Earth Potion");
		System.out.println("[3] Fire Potion");
		System.out.println("[4] Water Potion");
		System.out.println("[x] Back");
		
		int input = Game.scInt();
		Game.scStr();
		craftMenu(player, input, game);
		
	}

	public void craftMenu(Player player, int input, Game game) {
		
		
		switch (input) {
			case 1: {
				game.getAirPotion().showRecipe();
				player.craftPotion(game.getAirPotion());
				break;
			}
			case 2: {
				game.getEarthPotion().showRecipe();
				player.craftPotion(game.getEarthPotion()); 
				break;
			}
			case 3: {
				game.getFirePotion().showRecipe();
				player.craftPotion(game.getFirePotion());
				break;
			}
			case 4: {
				game.getWaterPotion().showRecipe();
				player.craftPotion(game.getWaterPotion());
				break;
			} 
			default:
				Choices(player, game);
				//throw new IllegalArgumentException("Unexpected value: " + input);
		}
	}

	public void mainMenu(Player player, int input, Game game) {
		
		switch (input) {
			case 1: {
				player.setPlayerLocation(game.getGeffenTown().getName()); 
				break;
			}
			case 2: {
				player.setPlayerLocation(game.getHolgrehennStore().getName()); 
				shopChoice(player, game.getHolgrehennStore(), game);
				break;
			}
			case 3: {
				player.setPlayerLocation(game.getTaalLake().getName()); 
				fishChoice(player, game.getTaalLake(), game);
				break;
			}
			case 4: {
				player.setPlayerLocation(game.getGalatheaDeep().getName()); 
				fishChoice(player, game.getGalatheaDeep(), game);
				break;
			}
			case 5: {
				player.setPlayerLocation(game.getMangroveForests().getName()); 
				fishChoice(player, game.getMangroveForests(), game);
				break;
			}
			case 6: {
				player.setPlayerLocation(game.getMindanaoCurrent().getName()); 
				fishChoice(player, game.getMindanaoCurrent(), game);
				break;
			}
			case 7: {
				player.checkBag(); 
				Choices(player, game); 
				break;
			}
			case 8: {
				game.setkeepRunning(false);
				break;
			}
			default:
				Choices(player, game);
				//throw new IllegalArgumentException("Unexpected value: " + input);
		}
		
	}

	private void shopChoice(Player player, Holgrehenn_Store store, Game game) {
		player.status();
		System.out.println("[1] Buy");
		System.out.println("[2] Sell");
		System.out.println("[x] Go back");
		
		int input = Game.scInt();
		Game.scStr();
		shopMenu(player, input, store, game);
	}

	private void shopMenu(Player player, int input, Holgrehenn_Store store, Game game) {
		
		
		
		switch (input) {
			case 1: {
				
				store.showShop();
				System.out.println("What do you want to buy:");
				int index = Game.scInt() - 1;
				System.out.println("How much do you want to buy:");
				int qty = Game.scInt();
				Game.scStr();
				
				
				player.buy(store.getMats().get(index), player, store, qty);
				Choices(player, game);
				break;
			}
			case 2: {
				
				player.checkBag();
				System.out.println("What do you want to sell:");
				int index = Game.scInt();
				System.out.println("How much do you want to sell:");
				int qty = Game.scInt();
				Game.scStr();

			
				player.sell(player.getItem_id().get(index), player, store, qty);
				Choices(player, game);
				break;
			}
			default:
				Choices(player, game); 
		}

	}

	private void fishChoice(Player player, Fishing_Spot fspot, Game game) {
		player.status();
		
		System.out.println("[1] Use bait");
		System.out.println("[2] Catch Fish");
		System.out.println("[x] Go back");
		
		int input = Game.scInt();
		fishMenu(player, input, fspot, game);
	}

	private void fishMenu(Player player, int input, Fishing_Spot fspot, Game game) {
		

		switch (input) {
			case 1: {
				player.useBait(); 
				fishChoice(player, fspot, game);
				break;
			}
			case 2: {
				player.catchFish(player, fspot); 
				Choices(player, game);
				break;
			}
			default:
				Choices(player, game);
		}
	}

	

	
}

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
		player.status();
		if (player.getPlayerLocation().equals(game.getGeffenTown().getName())) {
			System.out.println("[1] Craft Potion");
			craftMenu();
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
		mainMenu(player, input, game);
		
	}


	private void craftMenu() {


	}

	public void mainMenu(Player player, int input, Game game) {
		
		switch (input) {
		case 1: {
			player.setPlayerLocation(game.getGeffenTown().getName()); break;
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
			System.exit(input);
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + input);
		}
		
	}

	private void shopChoice(Player player, Holgrehenn_Store store, Game game) {
		player.status();
		System.out.println("[1] Buy");
		System.out.println("[2] Sell");
		
		int input = Game.scInt();
		Game.scStr();
		shopMenu(player, input, store, game);
	}

	private void shopMenu(Player player, int input, Holgrehenn_Store store, Game game) {
		String name = "";
		int qty = 0;
		int index = 0;
		
		switch (input) {
			case 1: {
				
				store.showShop();
				System.out.println("What do you want to buy:");
				name = Game.scStr();
				System.out.println("How much do you want to buy:");
				qty = Game.scInt();
				Game.scStr();
				
				index = store.lookForItem(name);
				player.buy(store.getMats().get(index), player, store, qty);

				Choices(player, game);
			}
			case 2: {
				player.checkBag();
				System.out.println("What do you want to sell:");
				name = Game.scStr();
				System.out.println("How much do you want to sell:");
				qty = Game.scInt();
				Game.scStr();

				index = player.lookForItem(name);
				
				player.sell(player.getBag().get(index), player, store, qty);

				Choices(player, game);
			}
			default:
				break;
		}

	}

	private void fishChoice(Player player, Fishing_Spot fspot, Game game) {
		player.status();
		System.out.println("[1] Go back");
		System.out.println("[2] Use bait");
		System.out.println("[3] Catch Fish");
		
		int input = Game.scInt();
		fishMenu(player, input, fspot, game);
	}

	private void fishMenu(Player player, int input, Fishing_Spot fspot, Game game) {
		boolean bait = false;

		switch (input) {
			case 1: {
				Choices(player, game); 
				break;
			}
			case 2: {
				bait = player.useBait(player, game.getAtlas()); 
				fishChoice(player, fspot, game);
				break;
			}
			case 3: {
				player.catchFish(player, fspot, bait); 
				Choices(player, game);
				break;
			}
			default:
			throw new IllegalArgumentException("Unexpected value: " + input);
		}
	}

	

	
}

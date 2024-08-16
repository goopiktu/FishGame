package mainMenu;

import Locations.fishingSpot.*;
import Locations.shop.ShopMenuHandler;
import main.Game;
import main.InteractiveMenu;
import player.Player;

public class MainMenu {
	private ShopMenuHandler shopMenuHandler;

	private String[] mainChoices = { "Geffen Town", "Holgrehenn Store", "Taal Lake", "Galathea Deep",
			"Dagupan Mangrove Forests", "Mindanao Current", "Bag" };

	private String[] potionChoices = { "Air Potion", "Earth Potion", "Fire Potion", "Water Potion" };

	private String[] fishChoices = { "Use Bait", "Catch Fish" };

	public MainMenu(Game game) throws InterruptedException {
		shopMenuHandler = new ShopMenuHandler(game.getHolgrehennStore());
		start(game);
	}

	public void start(Game game) throws InterruptedException {

		fishingPotionsAscii();
		System.out.println("Welcome Adventurer! What is your name? ");
		String name = Game.scStr();
		Player player = new Player(name);
		Choices(player, game);
	}

	public void Choices(Player player, Game game) throws InterruptedException {
		int input = 0;
		while (game.getkeepRunning()) {
			player.status();

			// Determine the first option based on the player's location
			String firstOption = player.getPlayerLocation().equals(game.getGeffenTown().getName())
					? "Craft Potion"
					: "Geffen Town";

			String[] menuOptions = new String[mainChoices.length];
			menuOptions[0] = firstOption;
			System.arraycopy(mainChoices, 1, menuOptions, 1, mainChoices.length - 1);

			// Display the menu
			InteractiveMenu menu = new InteractiveMenu(menuOptions);

			try {
				input = menu.display();
				input += 1;
				System.out.println("You selected: " + input);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (player.getPlayerLocation().equals(game.getGeffenTown().getName()) && input == 1) {
				craftChoice(player, game);
			} else {
				mainMenu(player, input, game);
			}
		}
	}

	private void craftChoice(Player player, Game game) throws InterruptedException {
		int input = 0;
		InteractiveMenu menu = new InteractiveMenu(potionChoices);

		try {
			input = menu.display();
			input += 1;
			System.out.println("You selected: " + input);
		} catch (Exception e) {
			e.printStackTrace();
		}

		craftMenu(player, input, game);

	}

	public void craftMenu(Player player, int input, Game game) throws InterruptedException {

		switch (input) {
			case 1: {
				game.getAirPotion().showRecipe(player);
				player.craftPotion(game.getAirPotion());
				break;
			}
			case 2: {
				game.getEarthPotion().showRecipe(player);
				player.craftPotion(game.getEarthPotion());
				break;
			}
			case 3: {
				game.getFirePotion().showRecipe(player);
				player.craftPotion(game.getFirePotion());
				break;
			}
			case 4: {
				game.getWaterPotion().showRecipe(player);
				player.craftPotion(game.getWaterPotion());
				break;
			}
			default:
				Choices(player, game);
				// throw new IllegalArgumentException("Unexpected value: " + input);
		}
	}

	public void mainMenu(Player player, int input, Game game) throws InterruptedException {

		switch (input) {
			case 1: {
				player.setPlayerLocation(game.getGeffenTown().getName());
				break;
			}
			case 2: {
				player.setPlayerLocation(game.getHolgrehennStore().getName());
				shopMenuHandler.shopChoice(player, game);
				// shopMenuHandler.shopChoice(player, game.getHolgrehennStore(), game);
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
				// System.out.println(Arrays.toString(player.bag.getBag().toArray()));

				player.bag.printBag();

				Choices(player, game);
				break;
			}
			case 8: {
				game.setkeepRunning(false);
				break;
			}
			default:
				Choices(player, game);
				// throw new IllegalArgumentException("Unexpected value: " + input);
		}

	}

	private void fishChoice(Player player, Fishing_Spot fspot, Game game) throws InterruptedException {
		int input = 0;
		player.status();

		InteractiveMenu menu = new InteractiveMenu(fishChoices);

		try {
			input = menu.display();
			input += 1;
			System.out.println("You selected: " + input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		fishMenu(player, input, fspot, game);
	}

	private void fishMenu(Player player, int input, Fishing_Spot fspot, Game game) throws InterruptedException {

		switch (input) {
			case 1: {
				player.useBait(game.getHolgrehennStore().getMats().get(3));
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

	private void fishingPotionsAscii() {
		System.out.println("  ______ _     _             _____      _   _                 \r\n" + //
				" |  ____(_)   | |           |  __ \\    | | (_)                \r\n" + //
				" | |__   _ ___| |__  _   _  | |__) |__ | |_ _  ___  _ __  ___ \r\n" + //
				" |  __| | / __| '_ \\| | | | |  ___/ _ \\| __| |/ _ \\| '_ \\/ __|\r\n" + //
				" | |    | \\__ \\ | | | |_| | | |  | (_) | |_| | (_) | | | \\__ \\\r\n" + //
				" |_|    |_|___/_| |_|\\__, | |_|   \\___/ \\__|_|\\___/|_| |_|___/\r\n" + //
				"                      __/ |                                   \r\n" + //
				"                     |___/        ");
	}

}

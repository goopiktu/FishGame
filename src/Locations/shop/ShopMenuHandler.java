package Locations.shop;

import main.Game;
import main.InteractiveMenu;
import player.Player;

public class ShopMenuHandler {

	private Shop shop;

	private String[] shopChoice = { "Buy", "Sell" };

	public ShopMenuHandler(Shop shop) {
		this.shop = shop;
	}

	public void shopChoice(Player player, Game game) {
		int input = 0;
		player.status();
		InteractiveMenu menu = new InteractiveMenu(shopChoice);
		try {
			input = menu.display();
			input += 1;
			System.out.println("You selected: " + input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		shopMenu(player, input, game);
	}

	public void shopMenu(Player player, int input, Game game) {
		switch (input) {
			case 1: {
				int index = 0;
				System.out.println("What do you want to buy:");

				this.shop.showShop();
				InteractiveMenu menu = new InteractiveMenu(this.shop.getMatsAsStrings());
				try {
					index = menu.display();
					index += 1;
					System.out.println("You selected: " + index);
				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("How much do you want to buy:");
				int qty = Game.scInt();
				Game.scStr();

				player.buy(this.shop.getMats().get(index), player, this.shop, qty);
				break;
			}
			case 2: {
				// System.out.println(player.);

				player.bag.printBag();
				System.out.println("What do you want to sell:");
				int index = Game.scInt();
				System.out.println("How much do you want to sell:");
				int qty = Game.scInt();
				Game.scStr();

				// System.out.println("Item by index " + player.bag.getItemByIndex(index));
				player.sell(player.bag.getItemByIndex(index - 1), player, this.shop, qty);
				break;
			}
		}

	}

}

package Locations.shop;

import main.Game;
import player.Player;

public class ShopMenuHandler {
    
    private Shop shop;

    public ShopMenuHandler(Shop shop) {
        this.shop = shop;
    }

    public void showShoppingMenu() {
        
    }

    public void handleShoppingInput(int input, Player player, Game game) {
        
    }

    public void shopChoice(Player player, Game game) {
		player.status();
		System.out.println("[1] Buy");
		System.out.println("[2] Sell");
		System.out.println("[x] Go back");
		
		int input = Game.scInt();
		Game.scStr();
		shopMenu(player, input, game);
	}

	public void shopMenu(Player player, int input, Game game) {
		
		
		
		switch (input) {
			case 1: {
				this.shop.showShop();
				System.out.println("What do you want to buy:");
				int index = Game.scInt() - 1;
				System.out.println("How much do you want to buy:");
				int qty = Game.scInt();
				Game.scStr();
				
				
				player.buy(this.shop.getMats().get(index), player, this.shop, qty);
				// Choices(player, game);
				break;
			}
			case 2: {
				
				player.bag.printBag();
				System.out.println("What do you want to sell:");
				int index = Game.scInt();
				System.out.println("How much do you want to sell:");
				int qty = Game.scInt();
				Game.scStr();

			
				player.sell(player.getItem_id().get(index), player, this.shop, qty);
				// Choices(player, game);
				break;
			}
		}

	}

}

package main;

import materials.Fish;
import player.Player;

public class test {
    
    public static void main(String[] args) {
        Fish hill = new Fish("Hillstream Loaches", 1000f, "Mindanao Current", "Rare");
        Fish tuna = new Fish("Tuna", 45f, "Mindanao Current", "Common");
        
        Player player = new Player("Aldwin");

        player.addItemToBag(tuna);
        player.addItemToBag(tuna);

        player.addItemToBag(hill);
        player.addItemToBag(hill);
        player.checkBag();
        System.out.println("\n");
        player.removefromBag(player.getItem_id().get(1).getName());
        player.removefromBag(player.getItem_id().get(1).getName());
        
        //System.out.println(player.getBag());
        player.checkBag();
        //player.checkBagString(1, tuna, player.getBag());
        player.removefromBag(player.getItem_id().get(1).getName());
        player.checkBag();

    }

}

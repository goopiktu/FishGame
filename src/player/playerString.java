package player;

import Locations.fishingSpot.Fishing_Spot;
import items.potions.*;

class playerString {

    public void statusString(String name, String playerLocation, double money) {
        System.out.format("+------------------------------------------+\n");
        System.out.format("|  NAME      |  %-25s  |\n", name);
        System.out.format("|  LOCATION  |  %-25s  |\n", playerLocation);
        System.out.format("|  MONEY     |  %25.3f  |\n", money);
        System.out.format("+------------------------------------------+\n");
    }

    public void fishCaughtCommonString(Fishing_Spot f) {
        String s = String.format("<< You caught a %s >>",
                f.getFishes().get(1).getName());

        System.out.println(s);
    }

    public void fishCaughtRareString(Fishing_Spot f) {
        String s = String.format("[[ You caught a %s ]]",
                f.getFishes().get(0).getName());
        System.out.println(s);
    }

    public void craftPotionString(Potions potion) {
        String s = String.format("CONGRATULATIONS!! YOU CRAFTED %s", potion.getName());
        System.out.println(s);
    }

}
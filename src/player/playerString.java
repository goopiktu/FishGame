package player;

import java.util.ArrayList;
import java.util.Collections;

import Locations.fishingSpot.Fishing_Spot;
import materials.Materials;

class playerString {

    

    public void checkBagString(int count, Materials m, ArrayList<Materials> bag){
        String s = String.format(COLORTEXT.color.CYAN_TEXT + "[%d] %s %s" + COLORTEXT.color.ANSI_RESET, count, m.getName(), Collections.frequency(bag, m));
        
        System.out.println(s);
    }

    public void statusString(String name, String playerLocation, double money) {
        String s = String.format(COLORTEXT.color.GREEN_TEXT +
								"Name: %s\nLocation: %s\nMoney: %,.2f" + 
								 COLORTEXT.color.ANSI_RESET, name, playerLocation, money); 
		System.out.println(s);
    }

    public void fishCaughtCommonString(Fishing_Spot f) {
        String s = String.format(COLORTEXT.color.WHITE_BG + 
									COLORTEXT.color.BLACK_TEXT + 
									"You caught a %s" +
									COLORTEXT.color.ANSI_RESET, f.getFishes().get(1).getName());
        System.out.println(s);
    }

    public void fishCaughtRareString(Fishing_Spot f) {
        String s = String.format(COLORTEXT.color.WHITE_BG + 
									COLORTEXT.color.RED_TEXT + 
									"You caught a %s" +
									COLORTEXT.color.ANSI_RESET, f.getFishes().get(0).getName());
        System.out.println(s);
    }


}
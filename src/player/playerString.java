package player;

import java.util.ArrayList;
import java.util.Collections;
import Locations.fishingSpot.Fishing_Spot;
import materials.Materials;

class playerString {

    

    public void checkBagString(int count, Materials m, ArrayList<Materials> bag){
        String s = String.format("|| [%d] %s %s ||", 
                                 count, m.getName(), Collections.frequency(bag, m));
        
        System.out.println(s);
    }

    public void statusString(String name, String playerLocation, double money) {
        
        int string_length = 35;
        char character_padding = ' ';
        name = "Name: " + name;
        playerLocation = "Location: " + playerLocation;
        String money_string = "Money: " + money;


        String n = String.format("%" + (-string_length) + "s" + "|\n" , name).replace(' ', character_padding);
    
        String p = String.format("%" + (-string_length) + "s" + "|\n" , playerLocation).replace(' ', character_padding);

        String m = String.format("%" + (-string_length) + "s" + "|" , money_string).replace(' ', character_padding);

        String s = n + p + m;
                                 
        System.out.println("------------------------------------");
		System.out.println(s);
        System.out.println("------------------------------------");
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


}
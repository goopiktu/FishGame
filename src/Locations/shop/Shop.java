package Locations.shop;

import java.util.ArrayList;

import items.Item;
import java.util.Map.Entry;
import items.material.Materials;
import main.InteractiveMenu;
import player.Player;

public class Shop {
    private String name;
    private ArrayList<Materials> mats;

    public Shop() {
        name = "";
        mats = new ArrayList<Materials>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Materials> getMats() {
        return mats;
    }

    public String[] getMatsAsStrings() {
        String[] temp = new String[mats.size()];
        int i = 0;
        for (Materials materials : mats) {

            temp[i] = String.format("||  %-20s  ||  %-3.2f  ||", materials.getName(), materials.getPrice());
            i++;
        }
        return temp;
    }

    public void setAllMats(ArrayList<Materials> mats) {
        this.mats = mats;
    }

    public void addAllMats(ArrayList<Materials> mats) {
        this.mats.addAll(mats);
    }

    public void addMats(Materials mats) {
        this.mats.add(mats);
    }

    public int showShop() {
        int index = 0;
        int count = 0;
        String spacer = "";
        String[] temp = new String[mats.size()];
        System.out.format("   #=============================================#\n");
        System.out.format("   ||%-15s_%-27s||\r\n" +
                "   ||%-10s  __| |_  ___ _ __    %-11s||\r\n" +
                "   ||%-10s (_-< ' \\/ _ \\ '_ \\%-14s||\r\n" +
                "   ||%-10s /__/_||_\\___/ .__/  %-11s ||\r\n" +
                "   ||%-10s             |_|      %-11s||\n", spacer, spacer, spacer, spacer, spacer, spacer, spacer,
                spacer, spacer, spacer);
        System.out.format("   #=============================================#\n");
        for (Materials i : this.mats) {
            temp[count] = String.format("||  %-20s  ||  %-3.2f  ||", i.getName(), i.getPrice());
            count++;

        }

        InteractiveMenu menu = new InteractiveMenu(temp);
        try {
            index = menu.buyShopMenu();
            index += 1;
            System.out.println("You selected: " + index);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.format("+------------------------------------------+\n");
        return index;
    }

    public int lookForItem(String name) {
        for (int i = 0; i < mats.size(); i++) {
            if (mats.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    public int checkPlayerBag(Player player) {
        String spacer = "Items";

        int input = 0;
        int i = 0;
        String[] temp = new String[player.getBagSize()];

        System.out.format("#==================================================#\n");
        System.out.format("||  Row  || %-30s || Qty ||\n", spacer);
        System.out.format("#==================================================#\n");

        for (Entry<Item, Integer> bag : player.getBag().getBag().entrySet()) {
            temp[i] = String.format("|| %-30s || %2d  ||", bag.getKey().getName(), bag.getValue());
            i++;
        }
        InteractiveMenu menu = new InteractiveMenu(temp);

        try {
            input = menu.displayBagMenu();
            System.out.printf("#=================================================#\n");
            input += 1;
            System.out.println("You selected: " + input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return input;

    }

}

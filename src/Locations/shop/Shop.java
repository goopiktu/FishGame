package Locations.shop;

import java.util.ArrayList;

import items.Item;
import java.util.Map.Entry;

import com.googlecode.lanterna.gui2.AnimatedLabel;

import items.material.Materials;
import main.InteractiveMenu;
import player.Player;

public class Shop {
    private String name;
    private ArrayList<Materials> mats;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_UNDERLINE = "\u001B[4m";

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

        System.out.format("   " + ANSI_UNDERLINE + "#=============================================#\n" + ANSI_RESET);

        System.out.format("%-3s" + ANSI_UNDERLINE + "|| %-3s ||  %-22s||  %-8s||\n" + ANSI_RESET, spacer, "Row",
                "Items",
                "Price");
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
        String blank = "";
        int input = 0;
        int i = 0;
        String[] temp = new String[player.getBagSize()];
        System.out.format("%-3s#==============================================#\n", blank);
        System.out.format( //
                "%-3s||%-44s||\r\n" + //
                        "%-3s||   _____                 _               %-3s||\r\n" + //
                        "%-3s||  |     |___ _ _ ___ ___| |_ ___ ___ _ _ %-3s||\r\n" + //
                        "%-3s||  |-   -|   | | | -_|   |  _| . |  _| | |%-3s||\r\n" + //
                        "%-3s||  |_____|_|_|\\_/|___|_|_|_| |___|_| |_  |%-3s||\r\n" + //
                        "%-3s||                                    |___|%-3s||\r\n",
                blank, blank, blank, blank, blank, blank, blank, blank, blank, blank, blank, blank);
        System.out.format("%-3s#==============================================#\n", blank);
        System.out.format("%-3s||  Row   || %-25s || Qty ||\n", blank, spacer);
        System.out.format("%-3s#==============================================#\n", blank);

        for (Entry<Item, Integer> bag : player.getBag().getBag().entrySet()) {
            if (temp.length - 1 == i) {
                temp[i] = String.format(ANSI_UNDERLINE + "|| %-25s || %2d  ||" + ANSI_RESET,
                        bag.getKey().getName(),
                        bag.getValue());
            } else {
                temp[i] = String.format("|| %-25s || %2d  ||", bag.getKey().getName(), bag.getValue());
            }

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

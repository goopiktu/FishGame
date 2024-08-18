package main;

import java.util.Scanner;
import Locations.fishingSpot.fishingSpots.*;
import Locations.shop.shops.Holgrehenn_Store;
import Locations.town.Town;
import items.Item;
import mainMenu.MainMenu;

//import player.Player;
public class Game {
    static Scanner sc = new Scanner(System.in);

    private static ItemAtlas itemAtlas = new ItemAtlas();
    private boolean keepRunning = true;

    private Taal_Lake taalLake;
    private Galathea_Deep galatheaDeep;
    private Dagupan_Mangrove_Forests mangroveForests;
    private Mindanao_Current mindanaoCurrent;
    private Holgrehenn_Store holgrehennStore;
    private Town geffenTown;
    private MainMenu menu;

    public Game(
            Taal_Lake taalLake,
            Galathea_Deep galatheaDeep,
            Dagupan_Mangrove_Forests mangroveForests,
            Mindanao_Current mindanaoCurrent,
            Holgrehenn_Store holgrehennStore,
            Town geffenTown) throws InterruptedException {
        this.taalLake = taalLake;
        this.galatheaDeep = galatheaDeep;
        this.mangroveForests = mangroveForests;
        this.mindanaoCurrent = mindanaoCurrent;
        this.holgrehennStore = holgrehennStore;
        this.geffenTown = geffenTown;
        this.menu = new MainMenu(this);
    }

    public static void main(String[] args) throws InterruptedException {
        // Create instances for each component and pass them to the Game constructor
        new Game(
                new Taal_Lake(itemAtlas),
                new Galathea_Deep(itemAtlas),
                new Dagupan_Mangrove_Forests(itemAtlas),
                new Mindanao_Current(itemAtlas),
                new Holgrehenn_Store(itemAtlas),
                new Town());
    }

    public <T extends Item> T getItemFromAtlas(String name, Class<T> type) {
        return itemAtlas.getItemByName(name, type);
    }

    public boolean getkeepRunning() {
        return keepRunning;
    }

    public void setkeepRunning(boolean keepRunning) {
        this.keepRunning = keepRunning;
    }

    public static String scStr() {
        return sc.nextLine();
    }

    public static int scInt() {
        return sc.nextInt();
    }

    public Taal_Lake getTaalLake() {
        return taalLake;
    }

    public Galathea_Deep getGalatheaDeep() {
        return galatheaDeep;
    }

    public Dagupan_Mangrove_Forests getMangroveForests() {
        return mangroveForests;
    }

    public Mindanao_Current getMindanaoCurrent() {
        return mindanaoCurrent;
    }

    public Holgrehenn_Store getHolgrehennStore() {
        return holgrehennStore;
    }

    public Town getGeffenTown() {
        return geffenTown;
    }

    public MainMenu getMenu() {
        return menu;
    }

}
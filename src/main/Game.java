package main;

import java.util.Scanner;
import Locations.fishingSpot.*;
import Locations.*;
import Locations.shop.shops.Holgrehenn_Store;
import items.potions.potion_types.*;
import mainMenu.MainMenu;

//import player.Player;
public class Game {
    static Scanner sc = new Scanner(System.in);
    private boolean keepRunning = true;

    private Taal_Lake taalLake;
    private Galathea_Deep galatheaDeep;
    private Dagupan_Mangrove_Forests mangroveForests;
    private Mindanao_Current mindanaoCurrent;
    private Holgrehenn_Store holgrehennStore;
    private Town geffenTown;
    private MainMenu menu;
    private Air_Potion airPotion;
    private Earth_Potion earthPotion;
    private Fire_Potion firePotion;
    private Water_Potion waterPotion;

    public Game(
        Taal_Lake taalLake,
        Galathea_Deep galatheaDeep,
        Dagupan_Mangrove_Forests mangroveForests,
        Mindanao_Current mindanaoCurrent,
        Holgrehenn_Store holgrehennStore,
        Town geffenTown,
        Air_Potion airPotion,
        Earth_Potion earthPotion,
        Fire_Potion firePotion,
        Water_Potion waterPotion
    ) {
        this.taalLake = taalLake;
        this.galatheaDeep = galatheaDeep;
        this.mangroveForests = mangroveForests;
        this.mindanaoCurrent = mindanaoCurrent;
        this.holgrehennStore = holgrehennStore;
        this.geffenTown = geffenTown;
        this.airPotion = airPotion;
        this.earthPotion = earthPotion;
        this.firePotion = firePotion;
        this.waterPotion = waterPotion;
        this.menu = new MainMenu(this);
    }

    public static void main(String[] args) {
        // Create instances for each component and pass them to the Game constructor
        new Game(
            new Taal_Lake(),
            new Galathea_Deep(),
            new Dagupan_Mangrove_Forests(),
            new Mindanao_Current(),
            new Holgrehenn_Store(),
            new Town(),
            new Air_Potion(),
            new Earth_Potion(),
            new Fire_Potion(),
            new Water_Potion()
        );
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

	

	public Air_Potion getAirPotion() {
		return airPotion;
	}

	public Earth_Potion getEarthPotion() {
		return earthPotion;
	}

	public Fire_Potion getFirePotion() {
		return firePotion;
	}

	public Water_Potion getWaterPotion() {
		return waterPotion;
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
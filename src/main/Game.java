package main;

import java.util.Scanner;
import Locations.fishingSpot.*;
import Locations.*;
import Locations.shop.*;
import mainMenu.MainMenu;
import potions.*;

//import player.Player;

public class Game {
	//boolean run = true;
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

	public Game() {
		initClasses();
	}

	public void initClasses() {
		taalLake = new Taal_Lake();
		galatheaDeep = new Galathea_Deep();
		mangroveForests = new Dagupan_Mangrove_Forests();
		mindanaoCurrent = new Mindanao_Current();
		holgrehennStore = new Holgrehenn_Store();
		geffenTown = new Town();
		airPotion = new Air_Potion("Air Potion", mindanaoCurrent, holgrehennStore);
		earthPotion = new Earth_Potion("Earth Potion", mangroveForests, holgrehennStore);
		firePotion = new Fire_Potion("Fire Potion", taalLake, holgrehennStore);
		waterPotion = new Water_Potion("Water Potion", galatheaDeep, holgrehennStore);
		menu = new MainMenu(this);
		
		
	}
	
	public static void main(String[] args) {
		//new init();
		new Game();
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
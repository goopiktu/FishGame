package main;

import java.util.Scanner;
import Locations.fishingSpot.*;
import Locations.*;
import Locations.shop.*;
import mainMenu.Atlas;
import mainMenu.MainMenu;

//import player.Player;

public class Game {
	//boolean run = true;
	static Scanner sc = new Scanner(System.in);
	
	private Taal_Lake taalLake;
	private Galathea_Deep galatheaDeep;
	private Dagupan_Mangrove_Forests mangroveForests;
	private Mindanao_Current mindanaoCurrent;
	private Holgrehenn_Store holgrehennStore;
	private Town geffenTown;
	private Atlas atlas;
	private MainMenu menu;

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
		atlas = new Atlas(this);
		menu = new MainMenu(this);
	}

	public static void main(String[] args) {
		//new init();
		new Game();
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

	public Atlas getAtlas() {
		return atlas;
	}

	public MainMenu getMenu() {
		return menu;
	}
	
	
	
	
}
		
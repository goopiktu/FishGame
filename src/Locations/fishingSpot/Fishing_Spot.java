package Locations.fishingSpot;

import java.util.ArrayList;

import items.material.materials.Fish;


/**
 * Fishing_Spot
 */
public class Fishing_Spot {
    
    private String name;
    private ArrayList<Fish> fishes;


    public Fishing_Spot(){
        this.name = "Unknown";
        this.fishes = new ArrayList<Fish>();
    }

    public Fishing_Spot(String name) {
        this.name = name;
        this.fishes = new ArrayList<Fish>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFishes(ArrayList<Fish> fishes) {
        this.fishes = fishes;
    }

    public ArrayList<Fish> getFishes() {
        return fishes;
    }

    public void addFish(Fish fish) {
        this.fishes.add(fish);
    }

    public void addMultiFish(ArrayList<Fish> fishes) { 
        this.fishes.addAll(fishes);
    }

    public void showFish() {
        for (Fish fish : fishes) {
            System.out.println(fish.toString()); 
        }
    }
    
}
package com.example.user.godzillakaijubattle;

import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Citizen> citizens;
    private ArrayList<IAttackable> buildings;

    public City(String name){
        this.name = name;
        this.citizens = new ArrayList<>();
        this.buildings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCitizen(Citizen citizen) {
        citizens.add(citizen);
    }

    public ArrayList<Citizen> getCitizens() {
        return citizens;
    }

    public void citizenEsacpes(Citizen evacuee){
        citizens.remove(evacuee);
    }

    public void addBuilding(IAttackable building) {
        buildings.add(building);
    }

    public ArrayList<IAttackable> getBuildings() {
        return buildings;
    }

    public void removeBuilding(IAttackable building) {
        buildings.remove(building);
    }
}

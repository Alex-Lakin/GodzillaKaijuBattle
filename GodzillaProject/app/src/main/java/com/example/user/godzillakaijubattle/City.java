package com.example.user.godzillakaijubattle;

import java.util.ArrayList;

public class City {
    private String name;
//    private ArrayList<Citizen> citizens;
    private ArrayList<IAttackable> targets;

    public City(String name){
        this.name = name;
//        this.citizens = new ArrayList<>();
        this.targets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

//    public void addCitizen(Citizen citizen) {
//        citizens.add(citizen);
//    }
//    public ArrayList<Citizen> getCitizens() {
//        return citizens;
//    }

    public void addTarget(IAttackable target) {
        targets.add(target);
    }
    public ArrayList<IAttackable> getTargets() {
        return targets;
    }
    public void removeTarget(IAttackable target) {
        targets.remove(target);
    }
}

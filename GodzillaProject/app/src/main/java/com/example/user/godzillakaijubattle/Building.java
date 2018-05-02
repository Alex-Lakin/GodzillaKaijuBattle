package com.example.user.godzillakaijubattle;

import java.util.ArrayList;

public class Building implements IAttackable {

    private String buildingType;
    private int hp;
    private int expGain;
//    private ArrayList<Citizen> occupants;

    public Building(String buildingType, int hp, int expGain){
        this.buildingType = buildingType;
        this.hp = hp;
        this.expGain = expGain;
//        this.occupants = new ArrayList<>();
    }

    public String getName() {
        return buildingType;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getExpGain() {
        return expGain;
    }

//    public ArrayList<Citizen> getOccupants() {
//        return occupants;
//    }
//
//    public void addOccupant(Citizen occupant){
//        occupants.add(occupant);
//    }
//
//    public void evacuateAndColapse(City streets){
//        for (int i = 0; i < occupants.size(); i++){
//            streets.addCitizen(occupants.get(i));
//        }
//        streets.getTargets().remove(this);
//    }
}

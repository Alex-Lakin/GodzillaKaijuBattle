package com.example.user.godzillakaijubattle;

import java.util.ArrayList;

public class Building implements IAttackable {

    private String buildingType;
    private int hp;
    private int expGain;
    private int evacuationPoint;

    public Building(String buildingType, int hp, int expGain, int evacuationPoint){
        this.buildingType = buildingType;
        this.hp = hp;
        this.expGain = expGain;
        this.evacuationPoint = evacuationPoint;
    }

    public int getEvacuationPoint() {
        return evacuationPoint;
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
}

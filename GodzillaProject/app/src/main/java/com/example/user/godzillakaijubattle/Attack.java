package com.example.user.godzillakaijubattle;

public class Attack {
    String name;
    int dmg;
    int stpCost;
    int levLock;

    public Attack(String name, int dmg, int stpCost, int levLock){
        this.name = name;
        this.dmg = dmg;
        this.stpCost = stpCost;
        this.levLock = levLock;
    }

    public String getName() {
        return name;
    }

    public int getDmg() {
        return dmg;
    }

    public int getStpCost() {
        return stpCost;
    }

    public int getLevLock() {
        return levLock;
    }
}

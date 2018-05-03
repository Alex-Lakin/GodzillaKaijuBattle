package com.example.user.godzillakaijubattle;

import java.io.Serializable;
import java.util.ArrayList;

public class Kaiju implements Serializable, IAttackable {

    private String name;
    private int hp;
    private int hpMax;
    private int stp;
    private int stpMax;
    private int lev;
    private int exp;
    private int expGain;
    private ArrayList<Attack> unlockedAttackList;
    private ArrayList<Attack> lockedAttackList;
    private int currentlySelectedAttack;
    private String imageLocation;
    private Player owner;

    public Kaiju(String name, int hp, int stp, int lev, int expGain, String imageLocation){
        this.name = name;
        this.lev = lev;
        this.hp = hp*lev;
        this.hpMax = hp*lev;
        this.stp = stp*lev;
        this.stpMax = stp*lev;
        this.expGain = expGain*lev;
        this.exp = 0;
        this.unlockedAttackList = new ArrayList<>();
        this.lockedAttackList = new ArrayList<>();
        this.currentlySelectedAttack = 0;
        this.imageLocation = imageLocation;
        this.owner = null;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getStp() {
        return stp;
    }

    public void regenStp() {
        if (stp <= stpMax-10) {
            this.stp += 10*lev;
        }
    }

    public int getStpMax() {
        return stpMax;
    }

    public int getLev() {
        return lev;
    }

    public void increaseLev() {
        this.lev ++;
        this.hpMax = getHpMax()*lev;
        this.hp = getHpMax();
        this.stpMax = getStpMax()*lev;
        this.stp = getStpMax();
        this.expGain = getExpGain()*lev;
//        cycle through locked attacks and transfer to unlocked if at correct level
        for (int i = 0; i < lockedAttackList.size(); i++){
            if (lockedAttackList.get(i).levLock == this.lev){
                unlockedAttackList.add(lockedAttackList.get(i));
                lockedAttackList.remove(i);
            }
        }
    }

    public int getExp() {
        return exp;
    }

    public void gainExp(int newexp) {
        this.exp += newexp;
    }

    public int getExpGain() {
        return expGain;
    }

    public void addAttack(Attack atk) {
        lockedAttackList.add(atk);
    }

    public Attack getCurrentAttack(){
        return unlockedAttackList.get(currentlySelectedAttack);
    }

    public void switchAttack(int plusOrMinus){
        currentlySelectedAttack += plusOrMinus;
        if (currentlySelectedAttack >= unlockedAttackList.size()){
            currentlySelectedAttack = 0;
        } else if (currentlySelectedAttack < 0) {
            currentlySelectedAttack = unlockedAttackList.size()-1;
        }
    }

    public void addFirstAttack(){
        if (unlockedAttackList.size() == 0) {
            unlockedAttackList.add(lockedAttackList.get(0));
            lockedAttackList.remove(0);
        }
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean attack(Attack attk, IAttackable opponent, City city){
//        if you have enough stp to perform attack
        if (this.stp >= attk.stpCost){
//            lower stp
            this.stp -= attk.stpCost;
//            damage opponent
            opponent.setHp(opponent.getHp()-attk.getDmg());
//            if opponent's hp is 0 or less
            if (opponent.getHp() <= 0){
//                get your exp reward
                this.gainExp(opponent.getExpGain());
//                level up if you have enough exp
                if (this.exp >= (this.lev * this.expGain)){
                    this.increaseLev();
                }
                return true;
            }
        }
        return false;
    }

    public void eatCitizen(Citizen snack){
        this.hp += snack.getNutritionalValue()*snack.getGroupSize();
        if (hp > hpMax) {hp = hpMax;}
    }
}

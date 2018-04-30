package com.example.user.godzillakaijubattle;

import java.io.Serializable;
import java.util.ArrayList;

public class Kaiju implements Serializable, IAttackable {

    private String name;
    private int hp;
    private int stp;
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
        this.stp = stp*lev;
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

    public int getStp() {
        return stp;
    }

    public void setStp(int stp) {
        this.stp = stp;
    }

    public int getLev() {
        return lev;
    }

    public void increaseLev() {
        this.lev ++;
        this.hp = getHp()*lev;
        this.stp = getStp()*lev;
        this.expGain = getExpGain()*lev;
    }

    public int getExp() {
        return exp;
    }

    public void gainExp(int newexp) {
        this.exp += newexp;
    }

//    @Override
    public int getExpGain() {
        return expGain;
    }

    public void addAttack(Attack atk) {
        lockedAttackList.add(atk);
    }

    public void unlockNextAttack() {
        unlockedAttackList.add(lockedAttackList.get(0));
        lockedAttackList.remove(0);
    }

    public Attack getCurrentAttack(){
        return unlockedAttackList.get(currentlySelectedAttack);
    }

    public void switchAttack(int plusOrMinus){
        currentlySelectedAttack += plusOrMinus;
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

    public void attack(int attkNum, int targetNum, City city){
//        get chosen attack from kaiju's attack array list
        Attack attack = unlockedAttackList.get(attkNum-1);
//        get chosen target (kaiju or building) from city's target arraylist
        IAttackable opponent = city.getTargets().get(targetNum-1);
//        if you have enough stp to perform attack
        if (this.stp >= attack.stpCost){
//            lower stp
            this.stp -= attack.stpCost;
//            damage opponent
            opponent.setHp(opponent.getHp()-attack.getDmg());
//            if opponent's hp is 0 or less
            if (opponent.getHp() <= 0){
//                get your exp reward
                this.gainExp(opponent.getExpGain());
//                level up if you have enough exp
                if (this.exp >= (this.lev * this.expGain)){
                    this.increaseLev();
                }
//                remove opponent from cities target list
                city.removeTarget(opponent);
            }
        }
    }

//    public void eatCitizen(City city){
//        Citizen snack = city.getCitizens().get(0);
//        this.hp += snack.getNutritionalValue();
//        city.getCitizens().remove(snack);
//    }
}

package com.example.user.godzillakaijubattle;

import java.util.ArrayList;

public class Kaiju {

    private String name;
    private int hp;
    private int stp;
    private int lev;
    private int exp;
    private int expGain;
//    private ArrayList<Attack> attackList;
    private Player owner;

    public Kaiju(String name, int hp, int stp, int lev, int expGain){
        this.name = name;
        this.hp = hp;
        this.stp = stp;
        this.lev = lev;
        this.expGain = expGain;
        this.exp = 0;
//        this.attackList = new ArrayList<>();
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

//    public void addAttack(Attack atk) {
//        attackList.add(atk);
//    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

//    public void attack(int attkNum, int targetNum, City city){
////        get chosen attack from kaiju's attack array list
//        Attack attack =  attackList.get(attkNum-1);
////        get chosen target (kaiju or building) from city's target arraylist
//        IAttackable opponent = city.getTargets().get(targetNum-1);
////        if you have enough stp to perform attack
//        if (this.stp >= attack.stpCost){
////            lower stp
//            this.stp -= attack.stpCost;
////            damage opponent
//            opponent.setHp(opponent.getHp()-attack.getDmg());
////            if opponent's hp is 0 or less
//            if (opponent.getHp() <= 0){
////                get you exp reward
//                this.gainExp(opponent.getExpGain());
////                level up if you have enough exp
//                if (this.exp >= (this.lev * this. expGain)){
//                    this.increaseLev();
//                }
////                remove opponent from cities target list
//                city.removeTarget(opponent);
//
//            }
//        }
//    }
//
//    public void eatCitizen(City city){
//        Citizen snack = city.getCitizens().get(0);
//        this.hp += snack.getNutritionalValue();
//        city.getCitizens().remove(snack);
//    }
}

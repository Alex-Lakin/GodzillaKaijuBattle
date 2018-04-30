package com.example.user.godzillakaijubattle;

import java.io.Serializable;
import java.util.ArrayList;

public class GameMaster implements Serializable {

    private ArrayList<Player> combatants;
    private int turn;
    private int round;
    private City currentCity;

    public GameMaster(){
        combatants = new ArrayList<Player>();
        turn = 0;
        round = 0;
        currentCity = null;
    }

    public ArrayList<Player> getAllCombatants() {
        return combatants;
    }

    public Player getCombatant(int num) {
        return combatants.get(num);
    }

    public void addCombatant(Player combatant) {
        combatants.add(combatant);
    }

    public int getTurn() {
        return turn;
    }

    public void nextTurn() {
        this.turn++;
        if (turn >= combatants.size()) {
            turn = 1;
            round ++;
        }
    }

    public int getRound() {
        return round;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }
}

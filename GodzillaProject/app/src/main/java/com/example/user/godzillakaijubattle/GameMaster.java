package com.example.user.godzillakaijubattle;

import java.io.Serializable;
import java.util.ArrayList;

public class GameMaster implements Serializable {

    private ArrayList<Player> combatants;
    private int turn;
    private int round;
    private City currentCity;

//    Kaiju list
    Kaiju godzilla;
    Attack clawSlash;
    Attack tailStrike;
    Attack atomicBreath;

    Kaiju kingGhidorah;
    Attack doubleTailWhip;
    Attack whirlWind;
    Attack gravityBeams;

    Kaiju mothra;
    Attack stinger;
    Attack windGust;
    Attack antennaBeams;

    public GameMaster(){
        combatants = new ArrayList<Player>();
        turn = 0;
        round = 0;
        currentCity = null;

//        setup Godzilla
        godzilla = new Kaiju("Godzilla",50,100,1,100,"godzilla");
        clawSlash = new Attack("Claw Slash", 10,10,1);
        tailStrike = new Attack("Tail Strike", 20,30,2);
        atomicBreath = new Attack("Atomic Breath", 30,50,3);
        godzilla.addAttack(clawSlash);
        godzilla.addAttack(tailStrike);
        godzilla.addAttack(atomicBreath);
        godzilla.unlockNextAttack();

//        setup King Ghidorah
        kingGhidorah = new Kaiju("King Ghidorah", 50, 100,1, 110,"king_ghidorah");
        doubleTailWhip = new Attack("Double Tail Whips", 10,10,1);
        whirlWind = new Attack("Whirl Wind", 30,40,2);
        gravityBeams = new Attack("Gravity Beams", 50,60,3);
        kingGhidorah.addAttack(doubleTailWhip);
        kingGhidorah.addAttack(whirlWind);
        kingGhidorah.addAttack(gravityBeams);
        kingGhidorah.unlockNextAttack();

//        setup mothra
        mothra = new Kaiju("Mothra", 50, 100,1, 110,"mothra");
        stinger = new Attack("Stinger", 10,10,1);
        windGust = new Attack("Wind Gust", 30,40,2);
        antennaBeams = new Attack("Antenna Beams", 50,60,3);
        mothra.addAttack(stinger);
        mothra.addAttack(windGust);
        mothra.addAttack(antennaBeams);
        mothra.unlockNextAttack();
    }

    public ArrayList<Player> getAllCombatants() {
        return combatants;
    }

    public Player getCombatant(int num) {
        return combatants.get(num-1);
    }

    public void addCombatant(Player combatant) {
        combatants.add(combatant);
    }

    public int getTurn() {
        return turn;
    }

    public void nextTurn() {
        this.turn++;
        if (turn > combatants.size()) {
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

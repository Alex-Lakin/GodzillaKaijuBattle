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

    Kaiju rodan;
    Attack clawKick;
    Attack harpoonBeak;
    Attack swoopingStrike;

    Kaiju mothra;
    Attack stinger;
    Attack windGust;
    Attack antennaBeams;

    Kaiju kingGhidorah;
    Attack doubleTailWhip;
    Attack whirlWind;
    Attack gravityBeams;

    Kaiju gigan;
    Attack bladeSlash;
    Attack chainsawBelly;
    Attack eyeLaser;

    Kaiju mechagodzilla;
    Attack ironClaw;
    Attack fingerRockets;
    Attack heatBeam;

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

//        setup Rodan
        rodan = new Kaiju("Rodan",50,100,1,100,"rodan");
        clawKick = new Attack("Claw Kick", 10,10,1);
        harpoonBeak = new Attack("Harpoon Beak", 20,30,2);
        swoopingStrike = new Attack("Swooping Strike", 30,50,3);
        rodan.addAttack(clawKick);
        rodan.addAttack(harpoonBeak);
        rodan.addAttack(swoopingStrike);
        rodan.unlockNextAttack();

//        setup mothra
        mothra = new Kaiju("Mothra", 50, 100,1, 110,"mothra");
        stinger = new Attack("Stinger", 10,10,1);
        windGust = new Attack("Wind Gust", 30,40,2);
        antennaBeams = new Attack("Antenna Beams", 50,60,3);
        mothra.addAttack(stinger);
        mothra.addAttack(windGust);
        mothra.addAttack(antennaBeams);
        mothra.unlockNextAttack();

//        setup King Ghidorah
        kingGhidorah = new Kaiju("King Ghidorah", 50, 100,1, 110,"king_ghidorah");
        doubleTailWhip = new Attack("Double Tail Whips", 10,10,1);
        whirlWind = new Attack("Whirl Wind", 30,40,2);
        gravityBeams = new Attack("Gravity Beams", 50,60,3);
        kingGhidorah.addAttack(doubleTailWhip);
        kingGhidorah.addAttack(whirlWind);
        kingGhidorah.addAttack(gravityBeams);
        kingGhidorah.unlockNextAttack();

//        setup Gigan
        gigan = new Kaiju("Gigan", 50, 100,1, 110,"gigan");
        bladeSlash = new Attack("Blade Slash", 10,10,1);
        chainsawBelly = new Attack("Chainsaw Belly", 30,40,2);
        eyeLaser = new Attack("Eye Laser", 50,60,3);
        gigan.addAttack(bladeSlash);
        gigan.addAttack(chainsawBelly);
        gigan.addAttack(eyeLaser);
        gigan.unlockNextAttack();

//        setup Mechagodzilla
        mechagodzilla = new Kaiju("Mechagodzilla", 50, 100,1, 110,"mechagodzilla");
        ironClaw = new Attack("Iron Claw", 10,10,1);
        fingerRockets = new Attack("Finger Rockets", 30,40,2);
        heatBeam = new Attack("Heat Beam", 50,60,3);
        mechagodzilla.addAttack(ironClaw);
        mechagodzilla.addAttack(fingerRockets);
        mechagodzilla.addAttack(heatBeam);
        mechagodzilla.unlockNextAttack();
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

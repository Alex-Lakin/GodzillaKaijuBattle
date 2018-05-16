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

    Kaiju anguirus;
    Attack bite;
    Attack tailSweep;
    Attack spikeRoll;

    Kaiju varan;
    Attack tailSwipe;
    Attack glidingPounce;
    Attack sonicBlast;

    Kaiju kingCaesar;
    Attack pawStrike;
    Attack flyingKick;
    Attack electroCharge;

    Kaiju gorosaurus;
    Attack chompingJaws;
    Attack kangarooKick;
    Attack burrowAmbush;

    Kaiju baragon;
    Attack hornRam;
    Attack flameRay;
    Attack chargingImpale;

    Kaiju gamera;
    Attack elbowClaw;
    Attack plasmaFireball;
    Attack spinningShell;

    Kaiju megalon;
    Attack drillingStrike;
    Attack lightningHorn;
    Attack napalmBomb;

    Kaiju titanosaurus;
    Attack tailCyclone;
    Attack jumpingSlam;
    Attack sonicWave;

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

    Kaiju battra;
    Attack poisonDust;
    Attack prismBeams;
    Attack kamikazeRam;

    Kaiju biollante;
    Attack vineWhips;
    Attack jawSnap;
    Attack corrosiveSap;

    Kaiju spaceGodzilla;
    Attack crystalShards;
    Attack coronaBeam;
    Attack telekinesis;

    Kaiju mechaKingGhidorah;
    Attack ironWings;
    Attack captureCables;
    Attack tripleLaser;

    Kaiju destroyah;
    Attack laserHorn;
    Attack chestBeam;
    Attack microOxygenBeam;

    Kaiju mechaGamera;
    Attack steelClaws;
    Attack homingRockets;
    Attack plasmaBeam;


    public GameMaster(){
        combatants = new ArrayList<Player>();
        turn = 0;
        round = 0;
        currentCity = null;

//        setup Godzilla
        godzilla = new Kaiju("Godzilla",50,20,1,100,"godzilla");
        clawSlash = new Attack("Claw Slash", 10,10,1);
        tailStrike = new Attack("Tail Strike", 20,30,2);
        atomicBreath = new Attack("Atomic Breath", 30,50,3);
        godzilla.addAttack(clawSlash);
        godzilla.addAttack(tailStrike);
        godzilla.addAttack(atomicBreath);
        godzilla.addFirstAttack();

//        setup Rodan
        rodan = new Kaiju("Rodan",50,20,1,100,"rodan");
        clawKick = new Attack("Claw Kick", 10,10,1);
        harpoonBeak = new Attack("Harpoon Beak", 20,30,2);
        swoopingStrike = new Attack("Swooping Strike", 30,50,3);
        rodan.addAttack(clawKick);
        rodan.addAttack(harpoonBeak);
        rodan.addAttack(swoopingStrike);
        rodan.addFirstAttack();

//        setup mothra
        mothra = new Kaiju("Mothra", 50, 20,1, 110,"mothra");
        stinger = new Attack("Stinger", 10,10,1);
        windGust = new Attack("Wind Gust", 30,40,2);
        antennaBeams = new Attack("Antenna Beams", 50,60,3);
        mothra.addAttack(stinger);
        mothra.addAttack(windGust);
        mothra.addAttack(antennaBeams);
        mothra.addFirstAttack();

//        setup anguirus
        anguirus = new Kaiju("Anguirus", 50, 20,1, 110,"anguirus");
        bite = new Attack("Bite", 10,10,1);
        tailSweep = new Attack("Tail Sweep", 20,20,2);
        spikeRoll = new Attack("Spike Roll", 50,60,3);
        anguirus.addAttack(bite);
        anguirus.addAttack(tailSweep);
        anguirus.addAttack(spikeRoll);
        anguirus.addFirstAttack();

//        setup varan
        varan = new Kaiju("Varan", 50, 20,1, 110,"varan");
        tailSwipe = new Attack("Tail Swipe", 10,10,1);
        glidingPounce = new Attack("Gliding Pounce", 20,20,2);
        sonicBlast = new Attack("Sonic Blast", 50,60,3);
        varan.addAttack(tailSwipe);
        varan.addAttack(glidingPounce);
        varan.addAttack(sonicBlast);
        varan.addFirstAttack();

//        setup kingCaesar
        kingCaesar = new Kaiju("King Caesar", 50, 20,1, 110,"king_caesar");
        pawStrike = new Attack("Paw Strike", 10,10,1);
        flyingKick = new Attack("Flying Kick", 20,20,2);
        electroCharge = new Attack("Electro-Charge", 50,60,3);
        kingCaesar.addAttack(pawStrike);
        kingCaesar.addAttack(flyingKick);
        kingCaesar.addAttack(electroCharge);
        kingCaesar.addFirstAttack();

//        setup gorosaurus
        gorosaurus = new Kaiju("Gorosaurus", 50, 20,1, 110,"gorosaurus");
        chompingJaws = new Attack("Jaw Chomp", 10,10,1);
        kangarooKick = new Attack("Kangaroo-Kick", 20,20,2);
        burrowAmbush = new Attack("Burrowing Ambush", 50,60,3);
        gorosaurus.addAttack(chompingJaws);
        gorosaurus.addAttack(kangarooKick);
        gorosaurus.addAttack(burrowAmbush);
        gorosaurus.addFirstAttack();

//        setup baragon
        baragon = new Kaiju("Baragon", 50, 20,1, 110,"baragon");
        hornRam = new Attack("Horn Ram", 10,10,1);
        flameRay = new Attack("Flame Ray", 20,20,2);
        chargingImpale = new Attack("Charging Impale", 50,60,3);
        baragon.addAttack(hornRam);
        baragon.addAttack(flameRay);
        baragon.addAttack(chargingImpale);
        baragon.addFirstAttack();

//        setup gamera
        gamera = new Kaiju("Gamera", 50, 20,1, 110,"gamera");
        elbowClaw = new Attack("Elbow Claw", 10,10,1);
        plasmaFireball = new Attack("Plasma Fireball", 20,20,2);
        spinningShell = new Attack("Spinning Shell", 50,60,3);
        gamera.addAttack(elbowClaw);
        gamera.addAttack(plasmaFireball);
        gamera.addAttack(spinningShell);
        gamera.addFirstAttack();

//        setup megalon
        megalon = new Kaiju("Megalon", 50, 20,1, 110,"megalon");
        drillingStrike = new Attack("Drilling Strike", 10,10,1);
        lightningHorn = new Attack("Lightning Horn", 20,20,2);
        napalmBomb = new Attack("Napal Bomb", 50,60,3);
        megalon.addAttack(drillingStrike);
        megalon.addAttack(lightningHorn);
        megalon.addAttack(napalmBomb);
        megalon.addFirstAttack();

//        setup titanosaurus
        titanosaurus = new Kaiju("Titanosaurus", 50, 20,1, 110,"titanosaurus");
        tailCyclone = new Attack("Tail Cyclone", 10,10,1);
        jumpingSlam = new Attack("Jumping Slam", 20,20,2);
        sonicWave = new Attack("Sonic Wave", 50,60,3);
        titanosaurus.addAttack(tailCyclone);
        titanosaurus.addAttack(jumpingSlam);
        titanosaurus.addAttack(sonicWave);
        titanosaurus.addFirstAttack();

//        setup King Ghidorah
        kingGhidorah = new Kaiju("King Ghidorah", 50, 20,1, 110,"king_ghidorah");
        doubleTailWhip = new Attack("Double Tail Whips", 10,10,1);
        whirlWind = new Attack("Whirl Wind", 30,40,2);
        gravityBeams = new Attack("Gravity Beams", 50,60,3);
        kingGhidorah.addAttack(doubleTailWhip);
        kingGhidorah.addAttack(whirlWind);
        kingGhidorah.addAttack(gravityBeams);
        kingGhidorah.addFirstAttack();

//        setup Gigan
        gigan = new Kaiju("Gigan", 50, 20,1, 110,"gigan");
        bladeSlash = new Attack("Blade Slash", 10,10,1);
        chainsawBelly = new Attack("Chainsaw Belly", 30,40,2);
        eyeLaser = new Attack("Eye Laser", 50,60,3);
        gigan.addAttack(bladeSlash);
        gigan.addAttack(chainsawBelly);
        gigan.addAttack(eyeLaser);
        gigan.addFirstAttack();

//        setup Mechagodzilla
        mechagodzilla = new Kaiju("Mechagodzilla", 50, 20,1, 110,"mechagodzilla");
        ironClaw = new Attack("Iron Claw", 10,10,1);
        fingerRockets = new Attack("Finger Rockets", 30,40,2);
        heatBeam = new Attack("Heat Beam", 50,60,3);
        mechagodzilla.addAttack(ironClaw);
        mechagodzilla.addAttack(fingerRockets);
        mechagodzilla.addAttack(heatBeam);
        mechagodzilla.addFirstAttack();

//        setup battra
        battra = new Kaiju("Battra", 50, 20,1, 110,"battra");
        poisonDust = new Attack("Poison Dust", 10,10,1);
        prismBeams = new Attack("Prism-Beams", 30,40,2);
        kamikazeRam = new Attack("Kamikaze Ram", 50,60,3);
        battra.addAttack(poisonDust);
        battra.addAttack(prismBeams);
        battra.addAttack(kamikazeRam);
        battra.addFirstAttack();

//        setup biollante
        biollante = new Kaiju("Biollante", 50, 20,1, 110,"biolante");
        vineWhips = new Attack("Vine Whips", 10,10,1);
        jawSnap = new Attack("Jaw-Snap", 30,40,2);
        corrosiveSap = new Attack("Corrosive Sap", 50,60,3);
        biollante.addAttack(vineWhips);
        biollante.addAttack(jawSnap);
        biollante.addAttack(corrosiveSap);
        biollante.addFirstAttack();

//        setup spacegodzilla
        spaceGodzilla = new Kaiju("Space Godzilla", 50, 20,1, 110,"space_godzilla");
        crystalShards = new Attack("Crystal Shards", 10,10,1);
        coronaBeam = new Attack("Corona-Beam", 30,40,2);
        telekinesis = new Attack("Telekinesis", 50,60,3);
        spaceGodzilla.addAttack(crystalShards);
        spaceGodzilla.addAttack(coronaBeam);
        spaceGodzilla.addAttack(telekinesis);
        spaceGodzilla.addFirstAttack();

//        setup mechakingghidorah
        mechaKingGhidorah = new Kaiju("Mecha-King Ghidorah", 50, 20,1, 110,"mecha_king_ghidorah");
        ironWings = new Attack("Iron Wings", 10,10,1);
        captureCables = new Attack("Capture Cables", 30,40,2);
        tripleLaser = new Attack("Triple Laser", 50,60,3);
        mechaKingGhidorah.addAttack(ironWings);
        mechaKingGhidorah.addAttack(captureCables);
        mechaKingGhidorah.addAttack(tripleLaser);
        mechaKingGhidorah.addFirstAttack();

//        setup destroyah
        destroyah = new Kaiju("Destroyah", 50, 20,1, 110,"destroyah");
        laserHorn = new Attack("Laser Horn", 10,10,1);
        chestBeam = new Attack("Chest Beam", 30,40,2);
        microOxygenBeam = new Attack("Micro-Oxygen Beam", 50,60,3);
        destroyah.addAttack(laserHorn);
        destroyah.addAttack(chestBeam);
        destroyah.addAttack(microOxygenBeam);
        destroyah.addFirstAttack();

//        setup mechagamera
        mechaGamera = new Kaiju("Mecha-Gamera", 50, 20,1, 110,"mecha_gamera");
        steelClaws = new Attack("Steel Claws", 10,10,1);
        homingRockets = new Attack("Homing Rockets", 30,40,2);
        plasmaBeam = new Attack("Plasma Beam", 50,60,3);
        mechaGamera.addAttack(steelClaws);
        mechaGamera.addAttack(homingRockets);
        mechaGamera.addAttack(plasmaBeam);
        mechaGamera.addFirstAttack();
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

    public void removeCombatant(Player combatant) {
        combatants.remove(combatant);
    }

    public int getTurn() {
        return turn;
    }

    public void nextTurn() {
        this.turn++;
        if (turn > combatants.size()) {
            turn = 1;
            round ++;
            for (Player combatant : combatants){
                combatant.getPlayersKaiju().regenStp();
            }
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

package com.example.user.godzillakaijubattle;

import java.io.Serializable;
import java.util.ArrayList;

public class GameMaster implements Serializable {

    private ArrayList<Player> combatants;

    public GameMaster(){
        combatants = new ArrayList<Player>();
    }

    public ArrayList<Player> getCombatants() {
        return combatants;
    }

    public void addCombatant(Player combatant) {
        combatants.add(combatant);
    }
}

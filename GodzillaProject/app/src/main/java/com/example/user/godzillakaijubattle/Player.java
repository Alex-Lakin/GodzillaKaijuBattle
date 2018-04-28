package com.example.user.godzillakaijubattle;

import java.io.Serializable;

public class Player implements Serializable {

    Kaiju myKaiju;
    Boolean aiControlled;

    public Player(Boolean aiControlled){
        this.myKaiju = null;
        this.aiControlled = aiControlled;
    }

    public void assignKaiju(Kaiju kaiju){
        myKaiju = kaiju;
        kaiju.setOwner(this);
    }

    public Kaiju getPlayersKaiju(){
        return myKaiju;
    }

    public Boolean getAiControlled() {
        return aiControlled;
    }

    public void setAiControlled(Boolean aiControlled) {
        this.aiControlled = aiControlled;
    }
}

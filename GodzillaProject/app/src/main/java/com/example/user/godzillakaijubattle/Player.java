package com.example.user.godzillakaijubattle;

import java.io.Serializable;

public class Player implements Serializable {

    private String pNumber;
    private Kaiju myKaiju;
    private Boolean aiControlled;

    public Player(String pNumber, Boolean aiControlled){
        this.pNumber = pNumber;
        this.myKaiju = null;
        this.aiControlled = aiControlled;
    }

    public String getPNumber() {
        return pNumber;
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

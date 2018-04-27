package com.example.user.godzillakaijubattle;

public class Player {

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

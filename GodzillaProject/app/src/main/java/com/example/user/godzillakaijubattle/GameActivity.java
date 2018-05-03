package com.example.user.godzillakaijubattle;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

//    world
    GameMaster controller;
    City tokyo;
    TextView currentCityText;
    TextView currentTurnText;
    ImageButton clickAnywhereElseButton;

//    buildings
    Building building1;
    Building building2;
    Building building3;
    ImageButton b1Button;
    ImageButton b2Button;
    ImageButton b3Button;
    ArrayList<View> buildingButtons;

//    citizens
    Citizen citizen1;
    Citizen citizen2;
    Citizen citizen3;
//    citizen buttons
    ImageButton citizenPos1;
    ImageButton citizenPos2;
    ImageButton citizenPos3;
    ImageButton citizenPos4;
    ImageButton citizenPos5;
    ImageButton citizenPos6;
    ImageButton citizenPos7;
    ImageButton citizenPos8;
    ImageButton citizenPos9;
    ImageButton citizenPos10;
    ImageButton citizenPos11;
    ImageButton citizenPos12;
    ImageButton citizenPos13;
    ImageButton citizenPos14;
    ImageButton citizenPos15;
    ImageButton citizenPos16;
    ImageButton citizenPos17;
    ImageButton citizenPos18;
    ImageButton citizenPos19;
    ImageButton citizenPos20;
    ImageButton citizenPos21;
    ImageButton citizenPos22;
    ImageButton citizenPos23;
    ArrayList<View> citizenButtons;

//    player 1
    Player p1;
    ImageButton player1Button;
    TextView p1HudStats;
    TextView p1HudAttk;
    ImageButton p1HudNextAttk;
    ImageButton p1HudPrevAttk;
    View[] p1buttons;

//    player 2
    Player p2;
    ImageButton player2Button;
    TextView p2HudStats;
    TextView p2HudAttk;
    ImageButton p2HudNextAttk;
    ImageButton p2HudPrevAttk;
    View[] p2buttons;



//    testing
    TextView testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

//        get game controller from prev screen
        Intent g = getIntent();
        Bundle extras = g.getExtras();
        controller = (GameMaster) extras.getSerializable("controller");

//        create city
        tokyo = new City("Tokyo");
        currentCityText = findViewById(R.id.cityTextViewId);
        currentCityText.setText(tokyo.getName());

//        create buildings
        building1 = new Building(" 1 ",30,100);
        building2 = new Building(" 2 ",30,100);
        building3 = new Building(" 3 ",30,100);
//        setup building buttons
        b1Button = findViewById(R.id.building1ImageButtonId);
        b2Button = findViewById(R.id.building2ImageButtonId);
        b3Button = findViewById(R.id.building3ImageButtonId);
        buildingButtons = new ArrayList<>();
        buildingButtons.add(b1Button);
        buildingButtons.add(b2Button);
        buildingButtons.add(b3Button);

//        add buildings to city
        tokyo.addBuilding(building1);
        tokyo.addBuilding(building2);
        tokyo.addBuilding(building3);

//        add citizens;
        citizen1 = new Citizen(10,4,19);
        tokyo.addCitizen(citizen1);

//        setup citizen buttons
        citizenPos1 = findViewById(R.id.citizensImageButtonId1);
        citizenPos2 = findViewById(R.id.citizensImageButtonId2);
        citizenPos3 = findViewById(R.id.citizensImageButtonId3);
        citizenPos4 = findViewById(R.id.citizensImageButtonId4);
        citizenPos5 = findViewById(R.id.citizensImageButtonId5);
        citizenPos6 = findViewById(R.id.citizensImageButtonId6);
        citizenPos7 = findViewById(R.id.citizensImageButtonId7);
        citizenPos8 = findViewById(R.id.citizensImageButtonId8);
        citizenPos9 = findViewById(R.id.citizensImageButtonId9);
        citizenPos10 = findViewById(R.id.citizensImageButtonId10);
        citizenPos11 = findViewById(R.id.citizensImageButtonId11);
        citizenPos12 = findViewById(R.id.citizensImageButtonId12);
        citizenPos13 = findViewById(R.id.citizensImageButtonId13);
        citizenPos14 = findViewById(R.id.citizensImageButtonId14);
        citizenPos15 = findViewById(R.id.citizensImageButtonId15);
        citizenPos16 = findViewById(R.id.citizensImageButtonId16);
        citizenPos17 = findViewById(R.id.citizensImageButtonId17);
        citizenPos18 = findViewById(R.id.citizensImageButtonId18);
        citizenPos19 = findViewById(R.id.citizensImageButtonId19);
        citizenPos20 = findViewById(R.id.citizensImageButtonId20);
        citizenPos21 = findViewById(R.id.citizensImageButtonId21);
        citizenPos22 = findViewById(R.id.citizensImageButtonId22);
        citizenPos23 = findViewById(R.id.citizensImageButtonId23);
        citizenButtons = new ArrayList<>();
        citizenButtons.add(citizenPos1);
        citizenButtons.add(citizenPos2);
        citizenButtons.add(citizenPos3);
        citizenButtons.add(citizenPos4);
        citizenButtons.add(citizenPos5);
        citizenButtons.add(citizenPos6);
        citizenButtons.add(citizenPos7);
        citizenButtons.add(citizenPos8);
        citizenButtons.add(citizenPos9);
        citizenButtons.add(citizenPos10);
        citizenButtons.add(citizenPos11);
        citizenButtons.add(citizenPos12);
        citizenButtons.add(citizenPos13);
        citizenButtons.add(citizenPos14);
        citizenButtons.add(citizenPos15);
        citizenButtons.add(citizenPos16);
        citizenButtons.add(citizenPos17);
        citizenButtons.add(citizenPos18);
        citizenButtons.add(citizenPos19);
        citizenButtons.add(citizenPos20);
        citizenButtons.add(citizenPos21);
        citizenButtons.add(citizenPos22);
        citizenButtons.add(citizenPos23);
        for (View button : citizenButtons){
            button.setVisibility(View.GONE);
        }

//        set up click anywhere else button
        clickAnywhereElseButton = findViewById(R.id.clickAnywhereElseImageButtonId);


//        get players
        p1 = controller.getCombatant(1);
        p2 = controller.getCombatant(2);

//        setup player character buttons
        player1Button = findViewById(R.id.player1ImageButtonId);
        player2Button = findViewById(R.id.player2ImageButtonId);
        int p1resourceId = getResources().getIdentifier(p1.getPlayersKaiju().getImageLocation(), "drawable", getPackageName());
        player1Button.setImageResource(p1resourceId);
        int p2resourceId = getResources().getIdentifier(p2.getPlayersKaiju().getImageLocation(), "drawable", getPackageName());
        player2Button.setImageResource(p2resourceId);


//        setup player stats and interface pop up
//          player 1
        p1HudStats = findViewById(R.id.p1StatsTextViewId);
        p1HudStats.setText("hp: " + p1.getPlayersKaiju().getHp() + " sp: " + p1.getPlayersKaiju().getStp());
        p1HudAttk = findViewById(R.id.p1CurrentAttackTextViewId);
        p1HudAttk.setText(p1.getPlayersKaiju().getCurrentAttack().getName());
        p1HudNextAttk = findViewById(R.id.p1NextAttkImageButtonId);
        p1HudPrevAttk = findViewById(R.id.p1PrevAttkImageButtonId);
        p1buttons = new View[]{p1HudStats,p1HudAttk,p1HudNextAttk,p1HudPrevAttk,clickAnywhereElseButton};
        for (View aView : p1buttons){
            aView.setVisibility(View.GONE);
        }

//          player2
        p2HudStats = findViewById(R.id.p2StatsTextViewId);
        p2HudStats.setText("hp: " + p2.getPlayersKaiju().getHp() + " sp: " + p2.getPlayersKaiju().getStp());
        p2HudAttk = findViewById(R.id.p2CurrentAttackTextViewId);
        p2HudAttk.setText(p2.getPlayersKaiju().getCurrentAttack().getName());
        p2HudNextAttk = findViewById(R.id.p2NextAttkImageButtonId);
        p2HudPrevAttk = findViewById(R.id.p2PrevAttkImageButtonId);
        p2buttons = new View[]{p2HudStats,p2HudAttk,p2HudNextAttk,p2HudPrevAttk,clickAnywhereElseButton};
        for (View aView : p2buttons){
            aView.setVisibility(View.GONE);
        }

//        start first turn
        controller.nextTurn();
        currentTurnText = findViewById(R.id.playerTurnTextViewId);
        currentTurnText.setText(controller.getCombatant(controller.getTurn()).getPlayersKaiju().getName() + "'s move.");


//        testing
        testText = findViewById(R.id.TestTextView);
        testText.setText("");
    }


    public void onClickedPlayerButton(View button){
        int whichPlayer = 0;
        View[] playersButtons;
        IAttackable target = null;
        if (button == player1Button){
            whichPlayer = 1;
            playersButtons = p1buttons;
            target = p1.getPlayersKaiju();
        } else if (button == player2Button){
            whichPlayer = 2;
            playersButtons = p2buttons;
            target = p2.getPlayersKaiju();
        } else {
            playersButtons = new View[]{};
        }
//        go to refactored method
        boolean aretheydefeated = attackOrShowStats(whichPlayer,playersButtons,target);
//        if an opponent is defeated
        if (aretheydefeated == true){
            if (whichPlayer == 1){
                controller.removeCombatant(p1);
                player1Button.setVisibility(View.GONE);
            } else if (whichPlayer == 2){
                controller.removeCombatant(p2);
                player2Button.setVisibility(View.GONE);
            }
//            move to next player
            controller.nextTurn();
////        update the screen with latest information
//            refreshScreen();
        }
    }

    public void onClickedPlayerNextAttack(View button){
//        select next attack in unlocked attack list
        controller.getCombatant(controller.getTurn()).getPlayersKaiju().switchAttack(1);
//        update the screen with latest information
        refreshScreen();
    }

    public void onClickedPlayerPrevAttack(View button){
//        select next attack in unlocked attack list
        controller.getCombatant(controller.getTurn()).getPlayersKaiju().switchAttack(-1);
//        update the screen with latest information
        refreshScreen();
    }

    public void onClickedBuildingButton(View button) {
        int whichBuilding = 0;
        IAttackable target = null;
        for (int i = 0; i < buildingButtons.size(); i++){
            if (button == buildingButtons.get(i)) {
                whichBuilding = i + 5;
                target = tokyo.getBuildings().get(i);
            }
        }
//        go to refactored method
        boolean isItDestroyed = attackOrShowStats(whichBuilding, new View[]{}, target);
//        if a building is destroyed
        if (isItDestroyed == true) {
            for (int i = 0; i < buildingButtons.size(); i++){
                if (whichBuilding == i + 5) {
                    tokyo.removeBuilding(tokyo.getBuildings().get(i));
                    buildingButtons.get(i).setVisibility(View.GONE);
                    buildingButtons.remove(i);
                }
            }
//        update the screen with latest information
            refreshScreen();
        }
    }

    public void onClickedAnwhereElseButton(View button){
        for (View aView : p1buttons){
            aView.setVisibility(View.GONE);
        }
        for (View aView : p2buttons){
            aView.setVisibility(View.GONE);
        }
        moveCitizens(tokyo);
    }

    public boolean attackOrShowStats(int p, View[] playersButtons, IAttackable target){
//        if its this players turn, show them stats and attacks
        if (controller.getTurn() == p){
            if (playersButtons[0].getVisibility() == View.GONE){
                for (View aView : playersButtons){
                    aView.setVisibility(View.VISIBLE);
                }
            }
//         if it is not this players turn, let an opponent attack
        } else {
//            get the player whose turn it is
            Player currentPlayersTurn = controller.getCombatant(controller.getTurn());
//            player whose turn it is attacks this player
            boolean aretheydefeated = currentPlayersTurn.getPlayersKaiju().attack(currentPlayersTurn.getPlayersKaiju().getCurrentAttack(),target,tokyo);
//            move to next player
            controller.nextTurn();
//            update the screen with latest information
            refreshScreen();
            return aretheydefeated;
        }
        return false;
    }

    public void moveCitizens(City city){
        if (city.getCitizens().size() > 0) {
            for (Citizen citizen : city.getCitizens()) {
                citizen.moveToNewPosition(city);
            }
            refreshScreen();
        }
        int i = 0;
        for (View button : citizenButtons){
            i++;
            for (Citizen cit : tokyo.getCitizens()){
                if (cit.getPos() == i){
                    button.setVisibility(View.VISIBLE);
                    break;
                } else {
                    button.setVisibility(View.GONE);
                }
            }
        }
    }

    public void refreshScreen(){
        currentTurnText.setText(controller.getCombatant(controller.getTurn()).getPlayersKaiju().getName() + "'s move.");
        p1HudStats.setText("hp: " + p1.getPlayersKaiju().getHp() + " sp: " + p1.getPlayersKaiju().getStp());
        p1HudAttk.setText(controller.getCombatant(1).getPlayersKaiju().getCurrentAttack().getName());
        p2HudStats.setText("hp: " + p2.getPlayersKaiju().getHp() + " sp: " + p2.getPlayersKaiju().getStp());
        p2HudAttk.setText(controller.getCombatant(2).getPlayersKaiju().getCurrentAttack().getName());
    }
}

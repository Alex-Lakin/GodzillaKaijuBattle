package com.example.user.godzillakaijubattle;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
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
    Building building4;
    Building building5;
    Building building6;
    Building building7;
    Building building8;
    Building building9;
    Building building10;
    Building building11;
    Building building12;
    Building building13;
    Building building14;
    Building building15;
    Building building16;
    ImageButton b1Button;
    ImageButton b2Button;
    ImageButton b3Button;
    ImageButton b4Button;
    ImageButton b5Button;
    ImageButton b6Button;
    ImageButton b7Button;
    ImageButton b8Button;
    ImageButton b9Button;
    ImageButton b10Button;
    ImageButton b11Button;
    ImageButton b12Button;
    ImageButton b13Button;
    ImageButton b14Button;
    ImageButton b15Button;
    ImageButton b16Button;
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
        building1 = new Building(" 1 ", 30, 100, 13);
        building2 = new Building(" 2 ", 40, 100,23);
        building3 = new Building(" 3 ", 40, 100,17);
        building4 = new Building(" 3 ", 30, 100,13);
        building5 = new Building(" 3 ", 30, 100,11);
        building6 = new Building(" 3 ", 50, 100,2);
        building7 = new Building(" 3 ", 30, 100,19);
        building8 = new Building(" 3 ", 20, 100,22);
        building9 = new Building(" 3 ", 30, 100,8);
        building10 = new Building(" 3 ", 50, 100,3);
        building11 = new Building(" 3 ", 30, 100,21);
        building12 = new Building(" 3 ", 20, 100,7);
        building13 = new Building(" 3 ", 30, 100,6);
        building14 = new Building(" 3 ", 50, 100,4);
        building15 = new Building(" 3 ", 30, 100,7);
//        add buildings to city
        tokyo.addBuilding(building1);
        tokyo.addBuilding(building2);
        tokyo.addBuilding(building3);
        tokyo.addBuilding(building4);
        tokyo.addBuilding(building5);
        tokyo.addBuilding(building6);
        tokyo.addBuilding(building7);
        tokyo.addBuilding(building8);
        tokyo.addBuilding(building9);
        tokyo.addBuilding(building10);
        tokyo.addBuilding(building11);
        tokyo.addBuilding(building12);
        tokyo.addBuilding(building13);
        tokyo.addBuilding(building14);
        tokyo.addBuilding(building15);

//        setup building buttons
        b1Button = findViewById(R.id.buildingImageButtonId1);
        b2Button = findViewById(R.id.buildingImageButtonId2);
        b3Button = findViewById(R.id.buildingImageButtonId3);
        b4Button = findViewById(R.id.buildingImageButtonId4);
        b5Button = findViewById(R.id.buildingImageButtonId5);
        b6Button = findViewById(R.id.buildingImageButtonId6);
        b7Button = findViewById(R.id.buildingImageButtonId7);
        b8Button = findViewById(R.id.buildingImageButtonId8);
        b9Button = findViewById(R.id.buildingImageButtonId9);
        b10Button = findViewById(R.id.buildingImageButtonId10);
        b11Button = findViewById(R.id.buildingImageButtonId11);
        b12Button = findViewById(R.id.buildingImageButtonId12);
        b13Button = findViewById(R.id.buildingImageButtonId13);
        b14Button = findViewById(R.id.buildingImageButtonId14);
        b15Button = findViewById(R.id.buildingImageButtonId15);
//        add building buttons to array list
        buildingButtons = new ArrayList<>();
        buildingButtons.add(b1Button);
        buildingButtons.add(b2Button);
        buildingButtons.add(b3Button);
        buildingButtons.add(b4Button);
        buildingButtons.add(b5Button);
        buildingButtons.add(b6Button);
        buildingButtons.add(b7Button);
        buildingButtons.add(b8Button);
        buildingButtons.add(b9Button);
        buildingButtons.add(b10Button);
        buildingButtons.add(b11Button);
        buildingButtons.add(b12Button);
        buildingButtons.add(b13Button);
        buildingButtons.add(b14Button);
        buildingButtons.add(b15Button);


//        create citizens;
        citizen1 = new Citizen(10, 4, 19);
        citizen2 = new Citizen(10, 5, 8);
        citizen3 = new Citizen(5, 5, 17);

//        add citizens to city streets
        tokyo.addCitizen(citizen1);
        tokyo.addCitizen(citizen2);
        tokyo.addCitizen(citizen3);

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

        updateCitizenPositions();

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
        p1buttons = new View[]{p1HudStats, p1HudAttk, p1HudNextAttk, p1HudPrevAttk, clickAnywhereElseButton};
        for (View aView : p1buttons) {
            aView.setVisibility(View.GONE);
        }

//          player2
        p2HudStats = findViewById(R.id.p2StatsTextViewId);
        p2HudStats.setText("hp: " + p2.getPlayersKaiju().getHp() + " sp: " + p2.getPlayersKaiju().getStp());
        p2HudAttk = findViewById(R.id.p2CurrentAttackTextViewId);
        p2HudAttk.setText(p2.getPlayersKaiju().getCurrentAttack().getName());
        p2HudNextAttk = findViewById(R.id.p2NextAttkImageButtonId);
        p2HudPrevAttk = findViewById(R.id.p2PrevAttkImageButtonId);
        p2buttons = new View[]{p2HudStats, p2HudAttk, p2HudNextAttk, p2HudPrevAttk, clickAnywhereElseButton};
        for (View aView : p2buttons) {
            aView.setVisibility(View.GONE);
        }

//        start first turn
        controller.nextTurn();
        currentTurnText = findViewById(R.id.playerTurnTextViewId);
        currentTurnText.setText(controller.getCombatant(controller.getTurn()).getPlayersKaiju().getName() + "'s move.");


//        testing
        testText = findViewById(R.id.TestTextView);
    }

    public void onClickedPlayerButton(View button) {
        int whichPlayer = 0;
        View[] playersButtons;
        IAttackable target = null;
        if (button == player1Button) {
            whichPlayer = 1;
            playersButtons = p1buttons;
            target = p1.getPlayersKaiju();
        } else if (button == player2Button) {
            whichPlayer = 2;
            playersButtons = p2buttons;
            target = p2.getPlayersKaiju();
        } else {
            playersButtons = new View[]{};
        }
//        go to refactored method
        boolean aretheydefeated = attackOrShowStats(whichPlayer, playersButtons, target);
//        if an opponent is defeated
        if (aretheydefeated == true) {
            if (whichPlayer == 1) {
                controller.removeCombatant(p1);
                player1Button.setVisibility(View.GONE);
                endGame(p2);
            } else if (whichPlayer == 2) {
                controller.removeCombatant(p2);
                player2Button.setVisibility(View.GONE);
                endGame(p1);
            }

        }
    }

    public void onClickedPlayerNextAttack(View button) {
//        select next attack in unlocked attack list
        controller.getCombatant(controller.getTurn()).getPlayersKaiju().switchAttack(1);
//        update the screen with latest information
        refreshScreen();
    }

    public void onClickedPlayerPrevAttack(View button) {
//        select next attack in unlocked attack list
        controller.getCombatant(controller.getTurn()).getPlayersKaiju().switchAttack(-1);
//        update the screen with latest information
        refreshScreen();
    }

    public void onClickedBuildingButton(View button) {
        int whichBuilding = 0;
        IAttackable target = null;
        for (int i = 0; i < buildingButtons.size(); i++) {
            if (button == buildingButtons.get(i)) {
                whichBuilding = i + 5;
                target = tokyo.getBuildings().get(i);
            }
        }
//        go to refactored method
        boolean isItDestroyed = attackOrShowStats(whichBuilding, new View[]{}, target);
//        if a building is destroyed
        if (isItDestroyed == true) {
            for (int i = 0; i < buildingButtons.size(); i++) {
                if (whichBuilding == i + 5) {
                    Building b = (Building) tokyo.getBuildings().get(i);
                    tokyo.removeBuilding(b);
                    for (Citizen citizen : tokyo.getCitizens()){
                        if (citizen.getPos() == 0){
                            citizen.setPos(b.getEvacuationPoint());
                            updateCitizenPositions();
                            break;
                        }
                    }
                    buildingButtons.get(i).setVisibility(View.GONE);
                    buildingButtons.remove(i);
                }
            }

//        update the screen with latest information
            refreshScreen();
        }
    }

    public void onClickCitizenButton(View clickedButton) {
        int pos = 0;
        Kaiju currentPlayerKaiju = controller.getCombatant(controller.getTurn()).getPlayersKaiju();
//        get pos, which is the buttons position in the array
        for (View button : citizenButtons) {
            if (clickedButton == button) {
                pos = citizenButtons.indexOf(button) + 1;
                break;
            }
        }
        for (Citizen citizen : tokyo.getCitizens()) {
            if (citizen.getPos() == pos) {
                currentPlayerKaiju.eatCitizen(citizen);
                citizen.setPos(0);
                clickedButton.setVisibility(View.GONE);
            }
        }
        controller.nextTurn();
        moveCitizens(tokyo);
        refreshScreen();
    }

    public void onClickedAnwhereElseButton(View button) {
        for (View aView : p1buttons) {
            aView.setVisibility(View.GONE);
        }
        for (View aView : p2buttons) {
            aView.setVisibility(View.GONE);
        }
        if (controller.getAllCombatants().size() == 1) {
            Intent goToCharacterSelect = new Intent(this, CharacterSelectActivity.class);
            startActivity(goToCharacterSelect);
        }
    }

    public boolean attackOrShowStats(int p, View[] playersButtons, IAttackable target) {
//        if its this players turn, show them stats and attacks
        if (controller.getTurn() == p) {
            if (playersButtons[0].getVisibility() == View.GONE) {
                for (View aView : playersButtons) {
                    aView.setVisibility(View.VISIBLE);
                }
            }
//         if it is not this players turn, let an opponent attack
        } else {
//            get the player whose turn it is
            Player currentPlayersTurn = controller.getCombatant(controller.getTurn());
//            player whose turn it is attacks this player
            boolean aretheydefeated = currentPlayersTurn.getPlayersKaiju().attack(currentPlayersTurn.getPlayersKaiju().getCurrentAttack(), target, tokyo);
//            move to next player
            controller.nextTurn();
//            move citizens
            moveCitizens(tokyo);
//            update the screen with latest information
            refreshScreen();
            return aretheydefeated;
        }
        return false;
    }

    public void moveCitizens(City city) {
        if (city.getCitizens().size() > 0) {
            for (Citizen citizen : city.getCitizens()) {
                citizen.moveToNewPosition(city);
            }
            refreshScreen();
        }
        updateCitizenPositions();
    }

    public void updateCitizenPositions() {

        //hide all buttons
        for (View button : citizenButtons) {
            button.setVisibility(View.GONE);
        }


        //show citizen buttons
        int i = 0;
        for (View button : citizenButtons) {
            i++;
            for (Citizen cit : tokyo.getCitizens()) {
                if (cit.getPos() == i) {
                    button.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void refreshScreen() {
        currentTurnText.setText(controller.getCombatant(controller.getTurn()).getPlayersKaiju().getName() + "'s move.");
        p1HudStats.setText("hp: " + p1.getPlayersKaiju().getHp() + " sp: " + p1.getPlayersKaiju().getStp());
        p1HudAttk.setText(controller.getCombatant(1).getPlayersKaiju().getCurrentAttack().getName());
        p2HudStats.setText("hp: " + p2.getPlayersKaiju().getHp() + " sp: " + p2.getPlayersKaiju().getStp());
        p2HudAttk.setText(controller.getCombatant(2).getPlayersKaiju().getCurrentAttack().getName());
    }

    public void endGame(Player winner) {
        currentTurnText.setText(winner.getPlayersKaiju().getName() + " is Victorious!");
        clickAnywhereElseButton.setVisibility(View.VISIBLE);
    }
}

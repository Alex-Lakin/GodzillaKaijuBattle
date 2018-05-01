package com.example.user.godzillakaijubattle;

import android.content.Intent;
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

//        get game controller from prev screen
        Intent g = getIntent();
        Bundle extras = g.getExtras();
        controller = (GameMaster) extras.getSerializable("controller");

//        create city
        tokyo = new City("Tokyo");
        currentCityText = findViewById(R.id.cityTextViewId);
        currentCityText.setText(tokyo.getName());


//        set up click anywhere else button
        clickAnywhereElseButton = findViewById(R.id.clickAnywhereElseImageButtonId);


//        get players
        p1 = controller.getCombatant(1);
        p2 = controller.getCombatant(2);


        tokyo.addTarget(controller.getCombatant(1).getPlayersKaiju());
        tokyo.addTarget(controller.getCombatant(2).getPlayersKaiju());


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
        testText.setText("test");
    }


    public void onClickedPlayerButton(View button){
        int whichPlayer = 0;
        View[] playersButtons;
        if (button == player1Button){
            whichPlayer = 1;
            playersButtons = p1buttons;
        } else if (button == player2Button){
            whichPlayer = 2;
            playersButtons = p2buttons;
        } else {
            playersButtons = new View[]{};}
        refactoredCharacterButtonActionsForThisPlayer(whichPlayer,playersButtons);
    }


    public void refactoredCharacterButtonActionsForThisPlayer(int p, View[] playersButtons){
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
            Player currentPlayersTurn = controller.getCombatant(controller.getTurn()-1);
//            player whose turn it is attacks this player
            currentPlayersTurn.getPlayersKaiju().attack(currentPlayersTurn.getPlayersKaiju().getCurrentAttack(),p-1,tokyo);
//            move on to next player
            controller.nextTurn();
//            update the screen with latest information
            refreshScreen();
        }
    }

    public void onClickedP1NextAttack(View button){
//        select next attack in unlocked attack list
        controller.getCombatant(1).getPlayersKaiju().switchAttack(1);
//        update the screen with latest information
        refreshScreen();
    }

    public void onClickedP1PrevAttack(View button){
//        select next attack in unlocked attack list
        controller.getCombatant(1).getPlayersKaiju().switchAttack(-1);
//        update the screen with latest information
        refreshScreen();
    }













    public void onClickedAnwhereElseButton(View button){
        for (View aView : p1buttons){
            aView.setVisibility(View.GONE);
        }
        for (View aView : p2buttons){
            aView.setVisibility(View.GONE);
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

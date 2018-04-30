package com.example.user.godzillakaijubattle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    GameMaster controller;
    City tokyo;
    TextView currentCityText;
    TextView currentTurnText;
    Player p1;
    Player p2;
    ImageButton player1Button;
    ImageButton player2Button;
    TextView p1HudHp;
    TextView p1HudStp;
    TextView p1HudAttk;
    ImageButton p1HudNextAttk;
    ImageButton p1HudPrevAttk;

    ImageButton clickAnywhereElseButton;

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


//        get players
        p1 = controller.getCombatant(1);
        p2 = new Player(true);
        Kaiju kingGhidorah = controller.kingGhidorah;
        p2.assignKaiju(kingGhidorah);
        controller.addCombatant(p2);
        tokyo.addTarget(controller.getCombatant(1).getPlayersKaiju());
        tokyo.addTarget(controller.getCombatant(2).getPlayersKaiju());


//        setup player buttons
        player1Button = findViewById(R.id.player1ImageButtonId);
        player2Button = findViewById(R.id.player2ImageButtonId);
        int p1resourceId = getResources().getIdentifier(p1.getPlayersKaiju().getImageLocation(), "drawable", getPackageName());
        player1Button.setImageResource(p1resourceId);
        int p2resourceId = getResources().getIdentifier(p2.getPlayersKaiju().getImageLocation(), "drawable", getPackageName());
        player2Button.setImageResource(p2resourceId);


//        setup player stats and interface
        p1HudHp = findViewById(R.id.p1HpTextViewId);
        p1HudHp.setText("hp: " + p1.getPlayersKaiju().getHp());
        p1HudStp = findViewById(R.id.p1StpTextViewId);
        p1HudStp.setText("stp: " + p1.getPlayersKaiju().getStp());
        p1HudAttk = findViewById(R.id.p1CurrentAttackTextViewId);
        p1HudAttk.setText(p1.getPlayersKaiju().getCurrentAttack().getName());
        p1HudNextAttk = findViewById(R.id.p1NextAttkImageButtonId);
        p1HudPrevAttk = findViewById(R.id.p1PrevAttkImageButtonId);


//        start first turn
        controller.nextTurn();
        currentTurnText = findViewById(R.id.playerTurnTextViewId);
        currentTurnText.setText(controller.getCombatant(controller.getTurn()).getPlayersKaiju().getName() + "'s move.");


//        misc
        clickAnywhereElseButton = findViewById(R.id.clickAnywhereElseImageButtonId);

//        testing
        testText = findViewById(R.id.TestTextView);
        testText.setText("test");
    }

    public void onClickedP1Button(View button){
        if (controller.getTurn() == 1){
            if (p1HudHp.getVisibility() == View.GONE){
                p1HudHp.setVisibility(View.VISIBLE);
                p1HudStp.setVisibility(View.VISIBLE);
                p1HudAttk.setVisibility(View.VISIBLE);
                p1HudNextAttk.setVisibility(View.VISIBLE);
                p1HudPrevAttk.setVisibility(View.VISIBLE);
                clickAnywhereElseButton.setVisibility(View.VISIBLE);
            }
        } else {
            Player currentPlayersTurn = controller.getCombatant(controller.getTurn()-1);
            currentPlayersTurn.myKaiju.attack(1,1,tokyo);
            controller.nextTurn();
            currentTurnText.setText(controller.getCombatant(controller.getTurn()).getPlayersKaiju().getName() + "'s move.");
            p1HudHp.setText("hp: " + p1.getPlayersKaiju().getHp());
            p1HudStp.setText("stp: " + p1.getPlayersKaiju().getStp());
        }
    }

    public void onClickedP2Button(View button){
        if (controller.getTurn() == 2){
//            get player stats
        } else {
            Player currentPlayersTurn = controller.getCombatant(controller.getTurn());
            currentPlayersTurn.myKaiju.attack(1,2,tokyo);
            controller.nextTurn();
            currentTurnText.setText(controller.getCombatant(controller.getTurn()).getPlayersKaiju().getName() + "'s move.");
        }
    }

    public void onClickedAnwhereElseButton(View button){
        p1HudHp.setVisibility(View.GONE);
        p1HudStp.setVisibility(View.GONE);
        p1HudAttk.setVisibility(View.GONE);
        p1HudNextAttk.setVisibility(View.GONE);
        p1HudPrevAttk.setVisibility(View.GONE);
        clickAnywhereElseButton.setVisibility(View.GONE);
    }
}

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

//    testing
    TextView testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent g = getIntent();
        Bundle extras = g.getExtras();
        controller = (GameMaster) extras.getSerializable("controller");

        tokyo = new City("Tokyo");
        currentCityText = findViewById(R.id.cityTextViewId);
        currentCityText.setText(tokyo.getName());

        p1 = controller.getAllCombatants().get(0);
        p2 = new Player(true);
        Kaiju kingGhidorah = new Kaiju("King Ghidorah",100,100,1,100);
        p2.assignKaiju(kingGhidorah);
        controller.addCombatant(p2);

        player1Button = findViewById(R.id.player1ImageButtonId);
        player2Button = findViewById(R.id.player2ImageButtonId);

        String kaijuName = p1.getPlayersKaiju().getName();
        if (kaijuName.equals("Godzilla")) {
            player1Button.setImageResource(R.drawable.godzilla);
        } else if (kaijuName.equals("King Ghidorah")){
            player1Button.setImageResource(R.drawable.king_ghidorah);
        }
        String kaiju2Name = p2.getPlayersKaiju().getName();
        if (kaiju2Name.equals("Godzilla")) {
            player2Button.setImageResource(R.drawable.godzilla);
        } else if (kaiju2Name.equals("King Ghidorah")){
            player2Button.setImageResource(R.drawable.king_ghidorah);
        }
        controller.nextTurn();
        currentTurnText = findViewById(R.id.playerTurnTextViewId);
        currentTurnText.setText(controller.getCombatant(controller.getTurn()-1).getPlayersKaiju().getName() + "'s move.");




//        testing
        testText = findViewById(R.id.TestTextView);
        testText.setText("Turn: " + controller.getTurn());
    }

    public void onClickedP1Button(View button){
        if (controller.getTurn() == 1){
//            get player stats
        } else {
            Player currentPlayersTurn = controller.getCombatant(controller.getTurn()-1);
            currentPlayersTurn.myKaiju.attack(1,1,tokyo);
            testText.setText("Turn: " + controller.getTurn());
        }
    }

    public void onClickedP2Button(View button){
        if (controller.getTurn() == 2){
//            get player stats
        } else {
            Player currentPlayersTurn = controller.getCombatant(controller.getTurn()-1);
            currentPlayersTurn.myKaiju.attack(1,2,tokyo);
            testText.setText("Turn: " + controller.getTurn());
        }
    }
}

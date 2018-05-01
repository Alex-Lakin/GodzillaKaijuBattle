package com.example.user.godzillakaijubattle;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CharacterSelectActivity extends AppCompatActivity {

    int arrayPosition;
    GameMaster controller;
    Player p1;
    Player p2;
    ArrayList<Kaiju> selectableCharacters;
    Kaiju godzilla;
    Kaiju rodan;
    Kaiju mothra;
    Kaiju kingGhidorah;
    Kaiju gigan;
    Kaiju mechagodzilla;
    ImageView characterImage;
    TextView characterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select);

        controller = new GameMaster();

//        set up selectable characters
        selectableCharacters = new ArrayList<>();
        arrayPosition = 0;
        godzilla = controller.godzilla;
        rodan = controller.rodan;
        mothra = controller.mothra;
        kingGhidorah = controller.kingGhidorah;
        gigan = controller.gigan;
        mechagodzilla = controller.mechagodzilla;
        selectableCharacters.add(godzilla);
        selectableCharacters.add(rodan);
        selectableCharacters.add(mothra);
        selectableCharacters.add(kingGhidorah);
        selectableCharacters.add(gigan);
        selectableCharacters.add(mechagodzilla);

//        create players and add them to controllers combatant list
        p1 = new Player("p1",false);
        p1.assignKaiju(godzilla);
        controller.addCombatant(p1);

        p2 = new Player("p2",true);
        p2.assignKaiju(kingGhidorah);
        controller.addCombatant(p2);

//        set up character name and image and set godzilla to default
        characterImage = findViewById(R.id.characterImageViewId);
        characterImage.setImageResource(R.drawable.godzilla);
        characterName = findViewById(R.id.CharacterNameTextViewId);
        characterName.setText(godzilla.getName());
    }

    public void onClickNextButton(View button){
        arrayPosition ++;
        if (arrayPosition >= selectableCharacters.size()){
            arrayPosition = 0;
        }
        changeCharacter();
    }

    public void onClickPreviousButton(View button){
        arrayPosition --;
        if (arrayPosition < 0){
            arrayPosition = (selectableCharacters.size()-1);
        }
        changeCharacter();
    }

    public void changeCharacter() {
        p1.assignKaiju(selectableCharacters.get(arrayPosition));
        characterName.setText(p1.getPlayersKaiju().getName());
        int resourceId = getResources().getIdentifier(p1.getPlayersKaiju().getImageLocation(), "drawable", getPackageName());
        characterImage.setImageResource(resourceId);
    }

    public void onClickPlayButton(View button){
        Intent startGame = new Intent(this,GameActivity.class);
        startGame.putExtra("controller",controller);
        startActivity(startGame);
    }


}

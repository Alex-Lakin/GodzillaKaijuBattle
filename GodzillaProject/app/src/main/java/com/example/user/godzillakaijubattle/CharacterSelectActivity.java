package com.example.user.godzillakaijubattle;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CharacterSelectActivity extends AppCompatActivity {


    GameMaster controller;
    Player p1;
    Player p2;
    ArrayList<Kaiju> selectableCharacters;
    int p1ArrayPosition;
    int p2ArrayPosition;
    Kaiju godzilla;
    Kaiju rodan;
    Kaiju mothra;
    Kaiju anguirus;
    Kaiju varan;
    Kaiju kingCaesar;
    Kaiju gorosaurus;
    Kaiju baragon;
    Kaiju gamera;
    Kaiju megalon;
    Kaiju titanosaurus;
    Kaiju kingGhidorah;
    Kaiju gigan;
    Kaiju mechagodzilla;
    Kaiju battra;
    Kaiju biollante;
    Kaiju spaceGodzilla;
    Kaiju mechaKingGhidorah;
    Kaiju destroyah;
    Kaiju mechaGamera;
    ImageView p1CharacterImage;
    TextView p1CharacterName;
    ImageButton p1Next;
    ImageButton p1Prev;
    ImageView p2CharacterImage;
    TextView p2CharacterName;
    ImageButton p2Next;
    ImageButton p2Prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        controller = new GameMaster();

//        set up selectable characters
        selectableCharacters = new ArrayList<>();
        p1ArrayPosition = 0;
        p2ArrayPosition = 1;
        godzilla = controller.godzilla;
        rodan = controller.rodan;
        mothra = controller.mothra;
        anguirus = controller.anguirus;
        varan = controller.varan;
        kingCaesar = controller.kingCaesar;
        gorosaurus = controller.gorosaurus;
        baragon = controller.baragon;
        gamera = controller.gamera;
        megalon = controller.megalon;
        titanosaurus = controller.titanosaurus;
        kingGhidorah = controller.kingGhidorah;
        gigan = controller.gigan;
        mechagodzilla = controller.mechagodzilla;
        battra = controller.battra;
        biollante = controller.biollante;
        spaceGodzilla = controller.spaceGodzilla;
        mechaKingGhidorah = controller.mechaKingGhidorah;
        destroyah = controller.destroyah;
        mechaGamera = controller.mechaGamera;
        selectableCharacters.add(godzilla);
        selectableCharacters.add(rodan);
        selectableCharacters.add(mothra);
        selectableCharacters.add(anguirus);
        selectableCharacters.add(varan);
        selectableCharacters.add(kingCaesar);
        selectableCharacters.add(gorosaurus);
        selectableCharacters.add(baragon);
        selectableCharacters.add(gamera);
        selectableCharacters.add(megalon);
        selectableCharacters.add(titanosaurus);
        selectableCharacters.add(kingGhidorah);
        selectableCharacters.add(gigan);
        selectableCharacters.add(mechagodzilla);
        selectableCharacters.add(battra);
        selectableCharacters.add(biollante);
        selectableCharacters.add(spaceGodzilla);
        selectableCharacters.add(mechaKingGhidorah);
        selectableCharacters.add(destroyah);
        selectableCharacters.add(mechaGamera);

//        create players and add them to controllers combatant list
        p1 = new Player("p1",false);
        p1.assignKaiju(godzilla);
        controller.addCombatant(p1);

        p2 = new Player("p2",true);
        p2.assignKaiju(rodan);
        controller.addCombatant(p2);

//        set up player 1's character name and image and set godzilla to default
        p1CharacterImage = findViewById(R.id.p1CharacterImageViewId);
        p1CharacterImage.setImageResource(R.drawable.godzilla);
        p1CharacterName = findViewById(R.id.p1CharacterNameTextViewId);
        p1CharacterName.setText(godzilla.getName());
        p1Next = findViewById(R.id.p1NextCharacterButtonId);
        p1Prev = findViewById(R.id.p1PreviousCharacterButtonId);
//        set up player 1's character name and image and set godzilla to default
        p2CharacterImage = findViewById(R.id.p2CharacterImageViewId);
        p2CharacterImage.setImageResource(R.drawable.rodan);
        p2CharacterName = findViewById(R.id.p2CharacterNameTextViewId);
        p2CharacterName.setText(rodan.getName());
        p2Next = findViewById(R.id.p2NextCharacterButtonId);
        p2Prev = findViewById(R.id.p2PreviousCharacterButtonId);
    }

    public void onClickNextButton(View button){
        if (button == p1Next){
//            next in array
            p1ArrayPosition ++;
//            if character is already selected by p2 skip it
            if (p1ArrayPosition == p2ArrayPosition){
                p1ArrayPosition ++;
            }
//            loop to start of array
            if (p1ArrayPosition >= selectableCharacters.size()){
                p1ArrayPosition = 0;
                if (p1ArrayPosition == p2ArrayPosition){
                    p1ArrayPosition ++;
                }
            }
//            call change character function
            changeCharacter(p1,p1ArrayPosition,p1CharacterImage,p1CharacterName);
        } else if (button == p2Next) {
            p2ArrayPosition++;

//            if character is already selected by p1 skip it
            if (p2ArrayPosition == p1ArrayPosition){
                p2ArrayPosition ++;
            }
            if (p2ArrayPosition >= selectableCharacters.size()) {
                p2ArrayPosition = 0;
                if (p2ArrayPosition == p1ArrayPosition){
                    p2ArrayPosition ++;
                }
            }
            changeCharacter(p2,p2ArrayPosition,p2CharacterImage,p2CharacterName);
        }
    }


    public void onClickPreviousButton(View button){
        if (button == p1Prev) {
            p1ArrayPosition--;
//            if character is already selected by p2 skip it
            if (p1ArrayPosition == p2ArrayPosition){
                p1ArrayPosition --;
            }
            if (p1ArrayPosition < 0) {
                p1ArrayPosition = (selectableCharacters.size() - 1);
                if (p1ArrayPosition == p2ArrayPosition){
                    p1ArrayPosition --;
                }
            }
            changeCharacter(p1,p1ArrayPosition,p1CharacterImage,p1CharacterName);
        } else if (button == p2Prev){
            p2ArrayPosition--;
//            if character is already selected by p1 skip it
            if (p2ArrayPosition == p1ArrayPosition){
                p2ArrayPosition --;
            }
            if (p2ArrayPosition < 0) {
                p2ArrayPosition = (selectableCharacters.size() - 1);
                if (p2ArrayPosition == p1ArrayPosition){
                    p2ArrayPosition --;
                }
            }
            changeCharacter(p2,p2ArrayPosition,p2CharacterImage,p2CharacterName);
        }
    }

    public void changeCharacter(Player p,int pPos, ImageView pPic,TextView pName) {
        p.assignKaiju(selectableCharacters.get(pPos));
        pName.setText(p.getPlayersKaiju().getName());
        int resourceId = getResources().getIdentifier(p.getPlayersKaiju().getImageLocation(), "drawable", getPackageName());
        pPic.setImageResource(resourceId);
    }

    public void onClickPlayButton(View button){
        Intent startGame = new Intent(this,GameActivity.class);
        startGame.putExtra("controller",controller);
        startActivity(startGame);
    }


}

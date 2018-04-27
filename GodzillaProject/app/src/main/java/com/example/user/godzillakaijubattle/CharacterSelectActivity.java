package com.example.user.godzillakaijubattle;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class CharacterSelectActivity extends AppCompatActivity {

    int arrayPosition;
    Player p1;
    ArrayList<Kaiju> selectableCharacters;
    Kaiju godzilla;
    Kaiju kingGhidorah;
    ImageView characterImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select);

        selectableCharacters = new ArrayList<>();
        arrayPosition = 0;
        godzilla = new Kaiju("Godzilla",50,50,1,100);
        kingGhidorah = new Kaiju("King Ghidorah",50,50,1,100);

        p1 = new Player(false);
        p1.assignKaiju(godzilla);

        characterImage = findViewById(R.id.characterImageViewId);
        characterImage.setImageResource(R.drawable.godzilla);

        selectableCharacters.add(godzilla);
        selectableCharacters.add(kingGhidorah);
    }

    public void onClickNextButton(View button){
        arrayPosition ++;
        if (arrayPosition >= selectableCharacters.size()){
            arrayPosition = 0;
        }
        p1.assignKaiju(selectableCharacters.get(arrayPosition));
        if (arrayPosition == 0) {
            characterImage.setImageResource(R.drawable.godzilla);
        } else if (arrayPosition == 1) {
            characterImage.setImageResource(R.drawable.mecha_king_ghidorah);
        }
    }

    public void onClickPreviousButton(View button){
        arrayPosition --;
        if (arrayPosition < 0){
            arrayPosition = (selectableCharacters.size()-1);
        }
        p1.assignKaiju(selectableCharacters.get(arrayPosition));
        if (arrayPosition == 0) {
            characterImage.setImageResource(R.drawable.godzilla);
        } else if (arrayPosition == 1) {
            characterImage.setImageResource(R.drawable.mecha_king_ghidorah);
        }
    }
}

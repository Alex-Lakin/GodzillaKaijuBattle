package com.example.user.godzillakaijubattle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TitleScreenActivity extends AppCompatActivity {

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        startButton = findViewById(R.id.startButtonId);
    }

    public void onStartButtonClicked(View button){
        Intent goToCharacterSelect = new Intent(this,CharacterSelectActivity.class);
        startActivity(goToCharacterSelect);
    }
}

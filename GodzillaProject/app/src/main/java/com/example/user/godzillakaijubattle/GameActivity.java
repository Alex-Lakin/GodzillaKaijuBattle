package com.example.user.godzillakaijubattle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    Player p1;
    TextView testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent player = getIntent();
        Bundle extras = player.getExtras();
        p1 = (Player) extras.getSerializable("player");

        testText = findViewById(R.id.testTextViewId);
        testText.setText(p1.getPlayersKaiju().getName());
    }
}

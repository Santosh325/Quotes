package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_display);
    }
    public void playAgainButton(View view) {
        // play tictactoe again
    }
    public void homeButton(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
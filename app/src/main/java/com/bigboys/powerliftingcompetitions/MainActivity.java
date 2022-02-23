package com.bigboys.powerliftingcompetitions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonParticipants = (Button)findViewById(R.id.buttonParticipants);
        Button buttonResults = (Button)findViewById(R.id.buttonResults);
        Button buttonRanking = (Button)findViewById(R.id.buttonRanking);

        View.OnClickListener ParticipantsClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openPActivity();
            }
            public void openPActivity () {
                Intent intent = new Intent(getApplicationContext(), Participants_Activity.class);
                startActivity(intent);
            }
        };
        buttonParticipants.setOnClickListener(ParticipantsClick);

        View.OnClickListener ResultsClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRSActivity();
            }
            public void openRSActivity () {
                Intent intent = new Intent(getApplicationContext(), Results_Activity.class);
                startActivity(intent);
            }
        };
        buttonResults.setOnClickListener(ResultsClick);

        View.OnClickListener RankingClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRActivity();
            }
            public void openRActivity () {
                Intent intent = new Intent(getApplicationContext(), Ranking_Activity.class);
                startActivity(intent);
            }
        };
        buttonRanking.setOnClickListener(RankingClick);
    }
}
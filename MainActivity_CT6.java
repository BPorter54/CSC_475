package com.gamecodeschool.learnasl101;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //sets view to main screen

        Button vocabButton = findViewById(R.id.vocab_button); //finds vocab button
        vocabButton.setOnClickListener(new View.OnClickListener() { //if clicked
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VocabCard.class)); //start vocab card class activity
            }
        });

     
        Button videoButton = findViewById(R.id.video_button); //finds video button
        videoButton.setOnClickListener(new View.OnClickListener() { //if clicked
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, YouTubeLink.class)); //start youtube link activity
            }
        });

        Button quizButton = findViewById(R.id.quiz_button); //find quiz button
        quizButton.setOnClickListener(new View.OnClickListener() { //if clicked
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Quiz.class)); //start quiz activity
            }
        });

        Button blurbButton = findViewById(R.id.blurb_button); //find blurb button
        blurbButton.setOnClickListener(new View.OnClickListener() { //if clicked
            @Override
            public void onClick(View v) {
                setContentView(R.layout.about_the_deaf_community); //set layout to "about"
                Button backButton = findViewById(R.id.back_to_main_button); //find back button
                backButton.setOnClickListener(new View.OnClickListener() { //if clicked
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.activity_main); // Go back to main screen
                    }
                });
            }
        });
    }
}
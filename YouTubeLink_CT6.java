//Credit: Jonathan. (2020, December 12). Android: Opening uris using intent - protocol case matters. Jonsdocs. 
// https://blog.jonsdocs.org.uk/2020/12/06/opening-uris-using-intent/ 

package com.gamecodeschool.learnasl101;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class YouTubeLink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_links); //set view to youtube link view


        ImageButton bestPracticesButton = findViewById(R.id.best_practices_button); //find best practices button
        bestPracticesButton.setOnClickListener(new View.OnClickListener() { //if clicked
            @Override
            public void onClick(View v) {
                openVideo("https://www.youtube.com/watch?v=IeeMM7Nts6I"); //load URL
            }
        });

        ImageButton loveSignButton = findViewById(R.id.common_gestures_button); //find common gestures button
        loveSignButton.setOnClickListener(new View.OnClickListener() { //if clicked
            @Override
            public void onClick(View v) {
                openVideo("https://www.youtube.com/watch?v=G6hVRVG74lc"); //load URL
            }
        });

        ImageButton signAButton = findViewById(R.id.alphabet_button); //find Alphabet button
        signAButton.setOnClickListener(new View.OnClickListener() { //if clicked
            @Override
            public void onClick(View v) {
                openVideo("https://www.youtube.com/watch?v=6_gXiBe9y9A"); //load URL
            }
        });

        ImageButton foodAslButton = findViewById(R.id.food_button); //find food button
        foodAslButton.setOnClickListener(new View.OnClickListener() { //if clicked
            @Override
            public void onClick(View v) {
                openVideo("https://www.youtube.com/watch?v=pMQJvFRqyV8"); //load URL
            }
        });


        Button homeButton = findViewById(R.id.home_screen_1); //find home button
        homeButton.setOnClickListener(new View.OnClickListener() { //if clicked
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main); //go to home screen
            }
        });
    }

    private void openVideo(String videoUrl) { //method to open and view the video
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl)); //intent to parse URL and view
        intent.putExtra("force_fullscreen", true); //sets to full screen
        startActivity(intent); //start activity
    }
}


//Credit: GeeksforGeeks. (2022, November 16). CardView using Recyclerview in Android with example.
// https://www.geeksforgeeks.org/cardview-using-recyclerview-in-android-with-example/

package com.gamecodeschool.learnasl101;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class VocabCard extends AppCompatActivity {

    private ArrayList<VocabularyCard> vocabularyList; //array list for vocab cards
    private int currentIndex = 0; //sets index of array list to 0
    private LinearLayout cardContainer; //card container for vocab card

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocab_card_layout); //sets vocab card layout

        cardContainer = findViewById(R.id.card_holder); //card container is the card holder view
        ImageButton backButton = findViewById(R.id.back_button); //initialize back button
        ImageButton nextButton = findViewById(R.id.next_button); //initialize next button
        Button vocab_home = findViewById(R.id.vocab_home); //initialize home button


        vocabularyList = new ArrayList<>(); //defines the image and definition for each vocab card in the array list
        vocabularyList.add(new VocabularyCard(R.drawable.asl_applove, "A Sign for Love"));
        vocabularyList.add(new VocabularyCard(R.drawable.asl_bath, "A Sign to take a Bath"));
        vocabularyList.add(new VocabularyCard(R.drawable.asl_bathroom, "A Sign to say you need to go to the Bathroom"));
        vocabularyList.add(new VocabularyCard(R.drawable.asl_drink, "A Sign to say you need to Drink"));
        vocabularyList.add(new VocabularyCard(R.drawable.asl_eat, "A Sign to say you need to Eat"));
        vocabularyList.add(new VocabularyCard(R.drawable.asl_hello, "A Sign to say Hello"));
        vocabularyList.add(new VocabularyCard(R.drawable.asl_homework, "A Sign to say Home and Work, to combine for Homework"));
        vocabularyList.add(new VocabularyCard(R.drawable.asl_sleep, "A Sign to say Sleep"));
        vocabularyList.add(new VocabularyCard(R.drawable.asl_water, "A Sign to say Water"));
        vocabularyList.add(new VocabularyCard(R.drawable.asl_car, "A Sign for Car"));


        displayCard(currentIndex); //displays card at index

        backButton.setOnClickListener(new View.OnClickListener() { //method for back button
            @Override
            public void onClick(View v) {
                if (currentIndex > 0) { //if not on first card
                    currentIndex--; //go back a card
                    displayCard(currentIndex); //display previous card
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() { //method for next button
            @Override
            public void onClick(View v) {
                if (currentIndex < vocabularyList.size() - 1) {
                    currentIndex++; //move to next card in the index
                    displayCard(currentIndex); //displays current card




                vocab_home.setOnClickListener(new View.OnClickListener() { //method to go back to the home screen
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.activity_main); //go to home screen
            }
        });
    }


                }

        });
    }


    private void displayCard(int index) { //displayCard method
        cardContainer.removeAllViews(); //remove view so next card can be displayed
        View cardView = getLayoutInflater().inflate(R.layout.card_layout, cardContainer, false); //inflates layout to the card container
        ImageView imageView = cardView.findViewById(R.id.imageViewASL); //find image within cardview
        TextView textView = cardView.findViewById(R.id.textViewDefinition); //find text within cardview
        VocabularyCard card = vocabularyList.get(index); //sets current card in index
        imageView.setImageResource(card.getImageResId()); //setter for image
        textView.setText(card.getDefinition()); //setter for definition
        cardContainer.addView(cardView); //add view to the card view
    }


    private static class VocabularyCard { //class for vocabulary card
        private final int imageResId; //initialize imageresid
        private final String definition; //initialize definition

        public VocabularyCard(int imageResId, String definition) { //constructor for vocabulary card
            this.imageResId = imageResId;
            this.definition = definition;
        }

        public int getImageResId() { //getter for image
            return imageResId;
        }

        public String getDefinition() { //getter for definition
            return definition;
        }

    }
}
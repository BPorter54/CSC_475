//Credit: Android studio - my code radio button doesn’t work when I run it. PhpOut. (n.d.).
// https://phpout.com/questions/android-studio/android-studio-my-code-radio-button-doesnt-work-when-i-run-it/

package com.gamecodeschool.learnasl101;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Quiz extends AppCompatActivity {

    private RadioGroup[] questionGroups; //radio group array to compare correct answers
    private int score = 0; //sets score to 0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout); //sets view to quiz layout


        questionGroups = new RadioGroup[]{ //radio groups for each question
                findViewById(R.id.question_1),
                findViewById(R.id.question_2),
                findViewById(R.id.question_3)

        };

        findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(); //when submit is clicked, check answers
            }
        });
    }

    private void checkAnswers() { //method to check answers

        int[] correctAnswers = new int[]{R.id.option_a_1, R.id.option_c_2, R.id.option_d_3}; //sets correct answers by option id for each question
        for (int i = 0; i < questionGroups.length; i++) { //for each radio group or question
            int selectedId = questionGroups[i].getCheckedRadioButtonId(); //selected ID is what the user selected
            if (selectedId != -1) { //if there are no unselected questions
                if (selectedId == correctAnswers[i]) { //if the selection is equal to the correct answer specified
                    score++; //add a point to the score
                }
            }
        }


        Toast.makeText(this, "Score: " + score + "/3", Toast.LENGTH_SHORT).show(); //display score
    }
}
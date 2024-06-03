//Author: Brandin Porter
// Date Completed: June 3rd, 2024
// Credit: How can I create tests in Android Studio?. Stack Overflow. (2020, January 1).
// https://stackoverflow.com/questions/16586409/how-can-i-create-tests-in-android-studio
//Credit: How to use switch case with spinner?. Stack Overflow. (2013, June 1).
// https://stackoverflow.com/questions/12935174/how-to-use-switch-case-with-spinner
//Credit: Add spinners to your app  :   views  :   android developers. Android Developers. (n.d.-a).
// https://developer.android.com/develop/ui/views/components/spinner#java 

package com.gamecodeschool.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner; //declare spinner for drop down menu
    private EditText userInput; //declare edittext for user input
    private Button submitButton; //declare submit button
    private TextView resultText; //declare result text to display answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.conversion_dropdown); //initialize spinner
        userInput = findViewById(R.id.user_input); //initialize user input
        submitButton = findViewById(R.id.submit); //initialize submit button
        resultText = findViewById(R.id.result); //initialize result

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( //adapter for spinner
                this,
                R.array.conversion_options_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        submitButton.setOnClickListener(new View.OnClickListener() { //on click listener for submit buttom
            @Override
            public void onClick(View v) { //when clicked
                convertUnits(); //execute convert units method
            }
        });
    }

    private void convertUnits() { //convert units method
        String selectedOption = spinner.getSelectedItem().toString(); //get user selction from drop down
        double inputValue = Double.parseDouble(userInput.getText().toString()); //get user input value
        double result = 0; //set result to 0
        String resultUnit = ""; //added unit to add specificity to result

        switch (selectedOption) { //for each case
            case "Kilograms to Pounds": //if user selects this
                result = inputValue * 2.20462; //perform this
                resultUnit = "pounds"; //add unit
                break;
            case "Pounds to Kilograms":
                result = inputValue / 2.20462;
                resultUnit = "kilograms";
                break;
            case "Fahrenheit to Celsius":
                result = (inputValue - 32) * 5 / 9;
                resultUnit = "°C";
                break;
            case "Celsius to Fahrenheit":
                result = (inputValue * 9 / 5) + 32;
                resultUnit = "°F";
                break;
            case "Feet to Meters":
                result = inputValue * 0.3048;
                resultUnit = "meters";
                break;
            case "Meters to Feet":
                result = inputValue / 0.3048;
                resultUnit = "feet";
                break;
        }

        resultText.setText(String.format("%.2f %s", result, resultUnit)); //print result to result text
    }
}
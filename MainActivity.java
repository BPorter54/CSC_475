//Author: Brandin Porter
//Date Completed: 5/6/24
//Credit: YouTube. (2020, August 3). To do list app Android Studio Tutorial
// | Part 4 - sqlite database | the penguin coders. YouTube. https://www.youtube.com/watch?v=e3fLWNEBPM0
//Credit: GeeksforGeeks. (2022, February 14). Create checkbox for each item in Listview in Android.
// https://www.geeksforgeeks.org/create-checkbox-for-each-item-in-listview-in-android/
//Credit: Horton, J. (2019). Android programming with Kotlin for beginners. Packt Publishing. ISBN: 9781789615401
//Credit: YouTube. (2020a, May 3). Build A to-do list app in Android Studio | Beginner’s guide.
// YouTube. https://www.youtube.com/watch?v=i9mkAoZ8FNk
package com.gamecodeschool.to_dolist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> items; //declare array list
    private ArrayAdapter<String> itemsAdapter; //declare adapter for ListView
    private ListView listView; //declare ListView
    private Button button; //declare button

    @Override
    protected void onCreate(Bundle savedInstanceState) { //on create method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView); //initialize listview
        button = findViewById(R.id.button); //initialize button

        button.setOnClickListener(new View.OnClickListener() { //on click listener for add button
            @Override
            public void onClick(View view) {
                addItem(); //add item to list
            }
        });

        items = new ArrayList<>(); //initialize arraylist
        itemsAdapter = new ArrayAdapter<>(this, R.layout.list_items, R.id.itemText, items); //initialize adapter
        listView.setAdapter(itemsAdapter);

        setUpListViewListener(); //method for checkbox listener
    }

    private void addItem() { //add item method
        EditText input = findViewById(R.id.editTextText); //takes user input
        String itemText = input.getText().toString();

        if (!itemText.isEmpty()) { //if the input is not empty
            itemsAdapter.add(itemText); //add text to list
            input.setText(""); //set to nothing
        } else { //if input is empty
            Toast.makeText(getApplicationContext(), "Please Enter Text", Toast.LENGTH_LONG).show(); //provide message to add text
        }
    }

    private void setUpListViewListener() { //long click method to delete items
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Item Removed", Toast.LENGTH_LONG).show(); //removed toast message
                items.remove(i); //remove item
                itemsAdapter.notifyDataSetChanged();
                return true; //return statement
            }
        });
    }

        private void checkBox(){ //method for checkbox to toggle
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //when clicked

                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    CheckBox checkBox = view.findViewById(R.id.checkBox);
                    checkBox.setChecked(!checkBox.isChecked()); //mark item as completed


                    ;
                }

                ;
            });
        }}
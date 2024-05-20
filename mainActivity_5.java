//Author: Brandin Porter
//Date Completed: 5/20/2024
//Credit: YouTube. (2023, March 26). Photo management app | android studio | part 1 | college project with source code
// | @ayeshaganaitech. YouTube. https://www.youtube.com/watch?v=zg0_YS9PYi4

package com.gamecodeschool.photogallery;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.os.Environment.MEDIA_MOUNTED;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static int PERMISSION_REQUEST_CODE = 100; //request permission code
    RecyclerView recycler; //recycler view to display images
    ArrayList<String> images; //array list to hold images
    GalleryAdapter adapter; //adapter for recyclerView
    GridLayoutManager manager; //grid for layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //set view to activity_main on open

        //initializes recycler, arrayList, adapter, and layout manager
        recycler = findViewById(R.id.gallery_recycler);
        images = new ArrayList<>();
        adapter = new GalleryAdapter(this, images);
        manager = new GridLayoutManager(this, 3);


        recycler.setAdapter(adapter); //sets adapter and layout manager
        recycler.setLayoutManager(manager);

        checkPermissions(); //calls permission check method

    }

    private void checkPermissions() { //check permissions method
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) { //if granted, load images
            loadImages();
        } else { //if not, request permissions
            ActivityCompat.requestPermissions(this, new String[]{READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) { //method for permission request check
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0) {
            boolean accepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            if (accepted) { //if approved, load images
                loadImages();
            } else { //if denied, display error message
                Toast.makeText(this, "You have denied the permissions..", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void loadImages() { //method to load images
        boolean SDCard = Environment.getExternalStorageState().equals(MEDIA_MOUNTED); //checks if SD card is mounted
        if (SDCard) {
            final String[] columns = {MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID}; //specifies columns
            final String order = MediaStore.Images.Media.DATE_TAKEN + " DESC"; //display by date taken in descending order

            Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null, null, order);
            int count = cursor.getCount();

            for (int i=0; i<count; i++) { //for each image in the array list
                cursor.moveToPosition(i);
                int columnindex = cursor.getColumnIndex(MediaStore.Images.Media.DATA); //get image path
                images.add(cursor.getString(columnindex)); //add images to column
            }

            recycler.getAdapter().notifyDataSetChanged(); //refresh recycler view
            cursor.close();


        }
    }

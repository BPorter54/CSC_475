package com.gamecodeschool.photogallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private Context context; //set context
    private ArrayList<String> images_list; //arrayList for images

    public GalleryAdapter(Context context, ArrayList<String> images_list) { //constructor for context and image list
        this.context = context;
        this.images_list = images_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //creates a new view holder
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_item, parent, false); //inflates layout of gallery item
        return new ViewHolder(view); //returns new viewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { //method to display image in specific position
        File image_file = new File(images_list.get(position));

        if (image_file.exists()) {
            Glide.with(context).load(image_file).into(holder.image); //loads image with Glide
        }
    }

    @Override
    public int getItemCount() {
        return images_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder { //class to represent each item in recyclerview

        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.gallery_item); //finds each image in the itemView
        }
    }
}
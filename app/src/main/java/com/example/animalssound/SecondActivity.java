package com.example.animalssound;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class SecondActivity extends AppCompatActivity {

    int[] arr_sounds = Animal.getArr_sounds();
    int[] arr_images = Animal.getArr_images();
    int[] arr_icons = Animal.getArr_icons();
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] arr_animals = getResources().getStringArray(R.array.animal_names);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        CustomAdapter adapter = new CustomAdapter(this, arr_animals, arr_icons);
        RecyclerView recyclerView = findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter.setOnItemClickListener(position -> {
            if (player != null && player.isPlaying()) {
                player.stop();
                player.release();
            }
            player = MediaPlayer.create(SecondActivity.this, arr_sounds[position]);
            player.start();
            final Dialog popupDialog = new Dialog(SecondActivity.this);
            popupDialog.setContentView(R.layout.popup);

            ImageView popupImage = popupDialog.findViewById(R.id.popupImage);

            popupImage.setImageResource(arr_images[position]);

            popupDialog.show();
            new Handler().postDelayed(popupDialog::dismiss, 3000);

        });
        recyclerView.setAdapter(adapter);
    }

}
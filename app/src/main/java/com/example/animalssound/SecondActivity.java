package com.example.animalssound;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity  {

    MediaPlayer player;
    Intent intent;
    ImageView imageView;
    Animal animal;
    private String[] arr_animals = {"Cat", "Cow", "Dog", "Goat", "Horse", "Rat", "Sheep", "Snake", "Wolf", "elephant", "giraffe", "tiger", "lion", "kangaroo", "penguin", "dolphin", "octopus", "koala", "rhinoceros", "chimpanzee"};
    private int[] arr_sounds = {R.raw.cat, R.raw.cow, R.raw.dog, R.raw.goat, R.raw.horse, R.raw.rat, R.raw.sheep, R.raw.snake, R.raw.wolf, R.raw.elephant, R.raw.giraffe, R.raw.tiger, R.raw.lion, R.raw.kangaroo, R.raw.penguin, R.raw.dolphin, R.raw.octopus, R.raw.koala, R.raw.rhinoceros, R.raw.chimpanzee};
    private int[] arr_images = {R.drawable.cat, R.drawable.cow, R.drawable.dog, R.drawable.goat, R.drawable.horse, R.drawable.rat, R.drawable.sheep, R.drawable.snake, R.drawable.wolf, R.drawable.elephant, R.drawable.giraffe, R.drawable.tiger, R.drawable.lion, R.drawable.kangaroo, R.drawable.penguin, R.drawable.dolphin, R.drawable.octopus, R.drawable.koala, R.drawable.rhinoceros, R.drawable.chimpanzee};
    private int[] arr_icons = {R.drawable.caticon, R.drawable.cowicon, R.drawable.dogicon, R.drawable.goaticon, R.drawable.horseicon, R.drawable.raticon, R.drawable.sheepicon, R.drawable.snakeicon, R.drawable.wolficon, R.drawable.elephanticon, R.drawable.giraffeicon, R.drawable.tigericon, R.drawable.lionicon, R.drawable.kangarooicon, R.drawable.penguinicon, R.drawable.dolphinicon, R.drawable.octopusicon, R.drawable.koalaicon, R.drawable.rhinocerosicon, R.drawable.chimpanzeeicon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        CustomAdapter adapter=new CustomAdapter(this,arr_animals,arr_icons);
        RecyclerView recyclerView=findViewById(R.id.rv);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter.setOnItemClickListener(new CustomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
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
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        popupDialog.dismiss();
                    }
                }, 3000);

            }
        });
        recyclerView.setAdapter(adapter);
    }

}
package com.example.animalssound;


import java.util.ArrayList;

public class Animal {
    private String name;
    private  int image,sound;

    public Animal(String name, int image, int sound) {
        this.name = name;
        this.image = image;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getSound() {
        return sound;
    }
}

package com.example.animalssound;


public class Animal {
    private static final int[] arr_sounds = {
            R.raw.cat, R.raw.cow, R.raw.dog, R.raw.goat, R.raw.horse, R.raw.rat,
            R.raw.sheep, R.raw.snake, R.raw.wolf, R.raw.elephant, R.raw.giraffe,
            R.raw.tiger, R.raw.lion, R.raw.kangaroo, R.raw.penguin, R.raw.dolphin,
            R.raw.octopus, R.raw.koala, R.raw.rhinoceros, R.raw.chimpanzee};
    private static final int[] arr_images = {R.drawable.cat, R.drawable.cow, R.drawable.dog,
            R.drawable.goat, R.drawable.horse, R.drawable.rat, R.drawable.sheep,
            R.drawable.snake, R.drawable.wolf, R.drawable.elephant, R.drawable.giraffe,
            R.drawable.tiger, R.drawable.lion, R.drawable.kangaroo, R.drawable.penguin,
            R.drawable.dolphin, R.drawable.octopus, R.drawable.koala, R.drawable.rhinoceros,
            R.drawable.chimpanzee};
    private static final int[] arr_icons = {R.drawable.caticon, R.drawable.cowicon, R.drawable.dogicon,
            R.drawable.goaticon, R.drawable.horseicon, R.drawable.raticon, R.drawable.sheepicon,
            R.drawable.snakeicon, R.drawable.wolficon, R.drawable.elephanticon, R.drawable.giraffeicon,
            R.drawable.tigericon, R.drawable.lionicon, R.drawable.kangarooicon, R.drawable.penguinicon,
            R.drawable.dolphinicon, R.drawable.octopusicon, R.drawable.koalaicon, R.drawable.rhinocerosicon,
            R.drawable.chimpanzeeicon};

    public static int[] getArr_sounds() {
        return arr_sounds;
    }

    public static int[] getArr_images() {
        return arr_images;
    }

    public static int[] getArr_icons() {
        return arr_icons;
    }
}

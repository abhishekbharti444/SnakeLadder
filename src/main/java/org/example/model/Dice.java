package org.example.model;

import java.util.Random;

public class Dice {
    private final int diceCount;

    private final int diceSize;

    public Dice(int diceCount, int diceSize) {
        this.diceCount = diceCount;
        this.diceSize = diceSize;
    }

    public int rollDice() {
        Random random = new Random();
        int min = this.diceCount;
        int max = this.diceCount * this.diceSize;

        return random.nextInt(max - min + 1) + min;
    }

}

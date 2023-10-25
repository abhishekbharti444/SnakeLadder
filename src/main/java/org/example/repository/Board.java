package org.example.repository;
import javafx.util.Pair;
import org.example.model.Ladder;
import org.example.model.Snake;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;

    public List<Integer> boardInstance = new ArrayList<Integer>(size);

    public List<Snake> snakes;
    public List<Ladder> ladders;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        for (int i = 0; i < size; ++i) {
            boardInstance.add(i + 1);
        }
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public int isSnake(int currCell) {
        for (int i = 0; i < this.snakes.size(); ++i) {
            if (this.snakes.get(i).getTop() == currCell) return i;
        }
        return -1;
    }

    public int isLadder(int currCell) {
        for (int i = 0; i < this.ladders.size(); ++i) {
            if (this.ladders.get(i).getBottom() == currCell) return i;
        }
        return -1;
    }
}

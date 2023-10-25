package org.example.model;

public class Ladder extends Actor {

    public Ladder(int top, int bottom) {
        super(top, bottom);
    }

    public int climb() {
        return this.getTop();
    }
}

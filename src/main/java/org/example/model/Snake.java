package org.example.model;

public class Snake extends Actor {
    public Snake(int top, int bottom) {
        super(top, bottom);
    }

    public int bite() {
        return this.getBottom();
    }
}

package org.example.model;

import org.example.repository.Board;

public class Player {
    private int id;
    private String name;

    private int currPosition;



    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.setCurrPosition(0);
    }

    public int getId() {
        return id;
    }

    public int getCurrPosition() {
        return currPosition;
    }

    public void setCurrPosition(int currPosition) {
        this.currPosition = currPosition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean wonTheGame(int currPosition, Board board) {
        return currPosition == board.getSize();
    }
    public int move(int diceNum, Board board) {
        if (this.currPosition + diceNum > board.getSize()) return this.currPosition;
        int finalPosition = this.currPosition;
        int currCellSnakeCheckIndex = board.isSnake(this.currPosition + diceNum);
        int currCellLadderCheckIndex = board.isLadder(this.currPosition + diceNum);

        if (currCellSnakeCheckIndex != -1) return board.snakes.get(currCellSnakeCheckIndex).bite();
        else if (currCellLadderCheckIndex != -1) return board.ladders.get(currCellLadderCheckIndex).climb();

        return this.currPosition + diceNum;
    }
}

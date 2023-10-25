package org.example;

import org.example.model.*;
import org.example.repository.Board;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to SNAKE and LADDER game you snakes!");

        int boardSize = 100;
        List<Snake> snakes = new ArrayList<>();
        snakes.add(0, new Snake(62, 5));
        snakes.add(1, new Snake(33, 6));
        snakes.add(2, new Snake(49, 9));
        snakes.add(3, new Snake(88, 16));
        snakes.add(4, new Snake(41, 20));
        snakes.add(5, new Snake(56, 53));
        snakes.add(6, new Snake(98, 64));
        snakes.add(7, new Snake(93, 73));
        snakes.add(8, new Snake(97, 75));

        List<Ladder> ladders = new ArrayList<>();

        ladders.add(0, new Ladder(37, 2));
        ladders.add(1, new Ladder(46, 27));
        ladders.add(2, new Ladder(32, 10));
        ladders.add(3, new Ladder(68, 51));
        ladders.add(4, new Ladder(79, 61));
        ladders.add(5, new Ladder(84, 65));
        ladders.add(6, new Ladder(91, 71));
        ladders.add(7, new Ladder(100, 81));

        Board board = new Board(boardSize, snakes, ladders);

        Player player1 = new Player(1, "Abhi");
        Player player2 = new Player(2, "Rakas");

        Player currPlayer = player1;

        Dice dice = new Dice(2, 6);
        int index = 0;
        while (true) {
            int diceNum = dice.rollDice();
            int prevPosition = currPlayer.getCurrPosition();
            int currPosition = currPlayer.move(diceNum, board);
            currPlayer.setCurrPosition(currPosition);
            System.out.println(currPlayer.getName() + " rolled a " + diceNum + " and moved from " + prevPosition + " to " + currPosition);
            if (currPlayer.wonTheGame(currPosition, board)) break;


            if (currPlayer == player1) currPlayer = player2;
            else currPlayer = player1;

            index++;
        }
        if (currPlayer.wonTheGame(currPlayer.getCurrPosition(), board)) System.out.println(currPlayer.getName() + " wins the game bitchis!!!!!");
        else System.out.println("Timeout!!!");
    }
}
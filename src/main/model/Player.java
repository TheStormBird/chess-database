package model;

import java.lang.Math.*;

//Stores and modifies all the actions of players
public class Player {
    private int playerID;
    private int wins = 0;
    private int losses = 0;
    String name;
    String title;
    int rating;

    //Creates a Player and sets its name, title, and wins and losses
    Player(String name, String title, int rating, int wins, int losses) {
        this.name = name;
        this.title = title;
        this.rating = rating;
        this.wins = wins;
        this.losses = losses;
        playerID = (int)(Math.random() * 100);
    }

    //MODIFIES: this
    //EFFECTS: Increases the number of wins
    void incrementWin() {
        wins++;
    }

    //MODIFIES: this
    //EFFECTS: Increases the number of losses
    void incrementLoss() {
        losses++;
    }


}

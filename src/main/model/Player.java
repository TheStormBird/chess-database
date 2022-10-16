package model;

import java.lang.Math.*;

//Stores and modifies all the actions of players
public class Player {
    private static int playerID = 0;
    private int wins = 0;
    private int losses = 0;
    String name;
    String title;
    int rating;

    //Creates a Player and sets its name, title, and wins and losses
    public Player(String name, String title, int rating, int wins, int losses) {
        this.name = name;
        this.title = title;
        this.rating = rating;
        this.wins = wins;
        this.losses = losses;
        playerID++;
    }

    public Player(String name, String title) {
        new Player(name, title, 0, 0, 0);
    }

    public Player(String name) {
        new Player(name, "Amateur");
    }

    //EFFECTS: returns the assigned player ID.
    int getPlayerID() {
        return playerID;
    }

    //EFFECTS: returns the name
    public String getName() {
        return name;
    }

    //EFFECTS: return the title of the player
    public String getTitle() {
        return title;
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

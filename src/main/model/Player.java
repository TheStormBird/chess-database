package model;

import org.json.JSONObject;
import persistence.Writable;

import java.lang.Math.*;

//Stores and modifies all the actions of players
public class Player implements Writable {
    private int wins;
    private int losses;
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
    }

    //Creates a player with name, title, and rating
    public Player(String name, String title, int rating) {
        this(name, title, rating, 0,0);
    }

    //Creates a player with only a name and a title
    public Player(String name, String title) {
        this(name, title, 0, 0, 0);
    }

    //Creates a player with only a name
    public Player(String name) {
        this(name, "Amateur");
    }


    //EFFECTS: returns the name
    public String getName() {
        return name;
    }

    //EFFECTS: return the title of the player
    public String getTitle() {
        return title;
    }

    //EFFECTS: Returns the ELO Rating
    public int getRating() {
        return rating;
    }

    //EFFECTS: Returns the number of wins
    public int getWins() {
        return wins;
    }

    //EFFECTS: Returns the number of losses
    public int getLosses() {
        return losses;
    }

    //MODIFIES: this
    //EFFECTS: Increases the number of wins
    void incrementWin() {
        this.wins++;
    }

    //MODIFIES: this
    //EFFECTS: Increases the number of losses
    void incrementLoss() {
        this.losses++;
    }

    //EFFECTS: Print out the details of the player
    public String printPlayer() {
        if (losses != 0) {
            return "Player Name:" + getName()
                    + " (" + getTitle() + ") \n ELO rating: " + getRating() + "\n Win/Loss Ratio: "
                    + (getWins() / getLosses());
        } else {
            return "Player Name:" + getName()
                    + " (" + getTitle() + ") \n ELO rating: " + getRating() + "\n Win/Loss Ratio: "
                    + 1;
        }
    }

    @Override
    public JSONObject toJson() {
        return null;
    }
}

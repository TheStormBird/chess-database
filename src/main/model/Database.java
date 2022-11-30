package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//Stores all the games and players and allows access
public class Database implements Writable {
    ArrayList<Game> games = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    private String name;


    //EFFECTS: Creates the database for all the information
    public Database(String name) {
        this.name = name;
    }

    //EFFECTS: Create a database without any specific name
    public Database() {
        this("User");
    }

    //EFFECTS: Returns the name of the Database
    public String getName() {
        return this.name;
    }

    //EFFECTS: Returns the arraylists for all players
    public ArrayList<Player> getPlayers() {
        return players;
    }

    //EFFECTS: Returns the arraylists for all games
    public ArrayList<Game> getGames() {
        return games;
    }

    //REQUIRES: A String name
    //EFFECTS: returns the player with the same name
    public Player searchPlayer(String name) {
        for (Player player: players) {
            if (player.getName().compareTo(name) == 0) {
                EventLog.getInstance().logEvent(new Event("Player with name " + name + " was looked up."));
                return player;
            }
        }
        EventLog.getInstance().logEvent(new Event("Player not found, new Player added."));
        return new Player(name);
    }

    //REQUIRES: An int ID
    //EFFECTS: returns the game object associated with the id
    public Game searchGame(int id) {
        for (Game game: games) {
            if (game.getGameID() == id) {
                EventLog.getInstance().logEvent(new Event("Game with id " + id + " was looked up."));
                return game;
            }
        }
        EventLog.getInstance().logEvent(new Event("Game not found!"));
        return null;
    }


    //REQUIRES: A Player object
    //MODIFIES: this
    //EFFECTS: Adds the player to the list of all players
    public boolean addPlayer(Player player) {
        players.add(player);
        EventLog.getInstance().logEvent(new Event("Player " + player.getName() + " was added to database."));
        return true;
    }

    //REQUIRES: A Game object
    //MODIFIES: this
    //EFFECTS: Adds the Game to the list of all games
    public boolean addGame(Game game) {
        games.add(game);
        EventLog.getInstance().logEvent(new Event("New Game was added to database."));
        return true;
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        JSONArray playerArray = new JSONArray();
        JSONArray gamesArray = new JSONArray();
        try {
            jsonObject.put("name", name);
            for (Player player: players) {
                playerArray.put(player.toJson());
            }
            for (Game game: games) {
                gamesArray.put(game.toJson());
            }
            jsonObject.put("players", playerArray);
            jsonObject.put("games", gamesArray);
        } catch (JSONException e) {
            System.out.println("Database could not be converted to JSON");
        }
        return jsonObject;
    }
}



package model;

import java.util.ArrayList;

//Stores all the games and players and allows access
public class Database {
    ArrayList<Game> games = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();


    //EFFECTS: Creates the database for all the information
    public Database() {
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
                return player;
            }
        }
        System.out.println("Player not found, new Player added.");
        return new Player(name);
    }

    //REQUIRES: An int ID
    //EFFECTS: returns the game object associated with the id
    public Game searchGame(int id) {
        for (Game game: games) {
            if (game.getGameID() == id) {
                return game;
            }
        }
        System.out.println("Game not found!");
        return null;
    }


    //REQUIRES: A Player object
    //MODIFIES: this
    //EFFECTS: Adds the player to the list of all players
    public boolean addPlayer(Player player) {
        players.add(player);
        return true;
    }

    //REQUIRES: A Game object
    //MODIFIES: this
    //EFFECTS: Adds the Game to the list of all games
    public boolean addGame(Game game) {
        games.add(game);
        return true;
    }
}



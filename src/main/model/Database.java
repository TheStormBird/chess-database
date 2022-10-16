package model;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

//Stores all the games and players and allows access
public class Database {
    ArrayList<Game> games = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();

    //EFFECTS: Creates the database for all the information
    public Database() {
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
    public void addPlayer(Scanner input) {
        System.out.println("Enter the name of the player:");
        String name = input.next();
        System.out.println("Enter the title of the player (if any):");
        String title = input.next();
        System.out.println("Enter the ELO rating of the player (if any):");
        int rating = input.nextInt();
        System.out.println("Enter the wins of the player (if any):");
        int wins = input.nextInt();
        System.out.println("Enter the losses of the player (if any):");
        int losses = input.nextInt();
        players.add(new Player(name, title, rating, wins, losses));
    }

    //REQUIRES: A Game object
    //MODIFIES: this
    //EFFECTS: Adds the game to the list of all games
    public void addGame(Scanner input) {
        System.out.println("Enter the name of player on white pieces: ");
        String nameWhite = input.nextLine();
        System.out.println("Enter the name of player on black pieces: ");
        String nameBlack = input.nextLine();
        System.out.println("Enter the location of the game: ");
        String location = input.nextLine();
        System.out.println("Enter the date of the game: ");
        String date = input.nextLine();
        Game game = new Game(searchPlayer(nameWhite), searchPlayer(nameBlack), location, date);
        String move;
        do {
            System.out.println("Enter the algebraic notation per FIDE outlines: ");
            move = input.nextLine();
            game.addMove(move);
        } while (!game.endGame(move));
    }
}

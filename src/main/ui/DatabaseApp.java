package ui;

import model.Database;
import model.Game;
import model.Player;

import java.util.Scanner;

public class DatabaseApp {

    DatabaseApp() {
        runDatabase();
    }

    void runDatabase() {
        Database database = new Database();
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            welcomeMsg();
            int command = input.nextInt();
            commandCenter(database, command, input);
            if (command == 5) {
                System.out.println("Do you want to save the newly added data? (y/n)");
                String answer = input.next();
                if (answer.compareTo("y") == 0) {

                }
                exit = true;
            }

        }
    }

    //REQUIRES: A Scanner object
    //MODIFIES: this
    //EFFECTS: Creates a Player Object
    static Player playerCreator(Scanner input) {
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
        return new Player(name, title, rating, wins, losses);
    }

    //REQUIRES: A Scanner object
    //MODIFIES: this
    //EFFECTS: Creates a Game Object
    public static Game gameCreator(Scanner input, Database database) {
        System.out.println("Enter the name of player on white pieces: ");
        String nameWhite = input.next();
        System.out.println("Enter the name of player on black pieces: ");
        String nameBlack = input.next();
        System.out.println("Enter the location of the game: ");
        String location = input.next();
        System.out.println("Enter the date of the game: ");
        String date = input.next();
        Game game = new Game(database.searchPlayer(nameWhite), database.searchPlayer(nameBlack), location, date);
        String move;
        do {
            System.out.println("Enter the algebraic notation per FIDE outlines: ");
            move = input.next();
            game.addMove(move);
        } while (!game.endGame(move));
        return game;
    }

    //EFFECTS: Shows the message in the command-line.
    static void welcomeMsg() {
        System.out.println("Welcome to Mohsen's Chess Database!\n"
                + "Enter 1: To add a new Player\n"
                + "Enter 2: To add a new Game\n"
                + "Enter 3: To look for a Player\n"
                + "Enter 4: To look for a certain game\n"
                + "Enter 5 to exit");
    }

    //REQUIRES: A scanner object and a command choice
    //EFFECTS: Goes through the different command options.
    static void commandCenter(Database database, int command, Scanner input) {
        switch (command) {
            case 1:
                database.addPlayer(playerCreator(input));
                System.out.println("Player added successfully.");
                break;
            case 2:
                database.addGame(gameCreator(input, database));
                System.out.println("Game added successfully.");
                break;
            case 3:
                System.out.println("Enter the name of the player: ");
                String name = input.next();
                Player player = database.searchPlayer(name);
                System.out.println(player.printPlayer());
                break;
            case 4:
                System.out.println("Enter the id for the game: ");
                int id = input.nextInt();
                Game game = database.searchGame(id);
                System.out.println(game.printGame());
                break;
        }
    }


}

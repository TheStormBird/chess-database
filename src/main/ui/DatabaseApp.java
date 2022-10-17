package ui;

import model.Database;

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
                exit = true;
            }

        }
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
                database.addPlayer(input);
                break;
            case 2:
                database.addGame(input);
                break;
            case 3:
                System.out.println("Enter the name of the player: ");
                String name = input.nextLine();
                database.searchPlayer(name);
                break;
            case 4:
                System.out.println("Enter the id for the game: ");
                int id = input.nextInt();
                database.searchGame(id);
                break;
        }
    }
}

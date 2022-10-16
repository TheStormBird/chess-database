package ui;

import model.Database;
import java.util.Scanner;

public class Main {
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void main(String[] args) {
        Database database = new Database();
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            welcomeMsg();
            int command = input.nextInt();
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
                case 5:
                    exit = true;
                    break;
            }
        }
    }

    static void welcomeMsg() {
        System.out.println("Welcome to Mohsen's Chess Database!\n"
                + "Enter 1: To add a new Player\n"
                + "Enter 2: To add a new Game\n"
                + "Enter 3: To look for a Player\n"
                + "Enter 4: To look for a certain game\n"
                + "Enter 5 to exit");
    }
}

//I found out about AtomicInteger while using the Oracle Documentation.

package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

//This class is responsible for storing and processing all
//information related to a single game of chess
public class Game implements Writable {
    private static AtomicInteger idCounter = new AtomicInteger();
    String location;
    String date;
    Player[] players = new Player[2];
    ArrayList<String> moves;
    int result;
    private final int gameID;

    //Creates a game object, puts players[0] as white, players[1] as black
    //and saves other information
    public Game(Player playerWhite, Player playerBlack, String location,String date, ArrayList<String> moves) {
        this.players[0] = playerWhite;
        this.players[1] = playerBlack;
        this.location = location;
        this.date = date;
        gameID = idCounter.getAndIncrement();
        this.moves = moves;
        endGame(moves.get(moves.size()));
    }

    public Game(Player playerWhite, Player playerBlack, String location,String date) {
        this(playerWhite, playerBlack, location,date, new ArrayList<>());
    }

    //EFFECTS: returns the gameID
    int getGameID() {
        return gameID;
    }

    //EFFECTS: return the array of the two players
    Player[] getPlayers() {
        return players;
    }

    //REQUIRES: A String representing a move
    //MODIFIES: this
    //EFFECTS: Add the move to the moves list and returns true
    //if the addition is successful
    public boolean addMove(String move) {
        if (verifyMove(move)) {
            moves.add(move);
            return true;
        } else {
            return false;
        }
    }

    //REQUIRES: a String representing a move
    //EFFECTS: verifies that the move is a valid one
    //based on FIDE notation outline
    boolean verifyMove(String move) {
        char[] availableCharacters = {'1', '2', '3', '4', '5', '6', '7', '8', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                'Q', 'K', 'N', 'B', 'R', 'x', '+', '=', '#'};
        if (move.length() < 2 || move.length() > 4) {
            return false;
        }
        for (int i = 0; i < move.length(); i++) {
            boolean found = false;
            for (char chr : availableCharacters) {
                if (move.charAt(i) == chr) {
                    found = true;
                    break;
                } else if (move.charAt(i) == '-') {
                    if (endGame(move)) {
                        return true;
                    }
                }
            }
            if (!found) {
                return false;
            }
        }
        moves.add(move);
        return true;
    }

    //REQUIRES: A String representing a move
    //MODIFIES: this
    //EFFECTS: Ends the game and modifies the result
    public boolean endGame(String move) {
        if (move.length() != 3 || move.charAt(1) != '-') {
            return false;
        }
        if (move.charAt(0) == '1' && move.charAt(2) == '0') {
            result = 0;
            players[0].incrementWin();
            players[1].incrementLoss();
            moves.add(move);
            return true;
        } else if (move.charAt(0) == '0' && move.charAt(2) == '1') {
            result = 1;
            players[1].incrementWin();
            players[0].incrementLoss();
            moves.add(move);
            return true;
        }
        return false;
    }

    //EFFECTS: Print out the details of the game
    public String printGame() {
        return "Player with white pieces: " + getPlayers()[0].getName() + " \n Player with the black pieces"
                + getPlayers()[1].getName() + "\n location:" + location + "\n date: " + date
                + "The winner of the game is: " + getPlayers()[result].getName() + " ("
                + getPlayers()[result].getTitle() + ")\n";
    }

    @Override
    public JSONObject toJson() {
        return null;
    }
}

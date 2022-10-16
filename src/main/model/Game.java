package model;

import java.util.ArrayList;

//This class is responsible for storing and processing all
//information related to a single game of chess
public class Game {
    private static int gameID = 0;
    String location;
    String date;
    Player[] players = new Player[2];
    ArrayList<String> moves = new ArrayList<String>();
    int result;

    //Creates a game object, puts players[0] as white, players[1] as black
    //and saves other information
    public Game(Player playerWhite, Player playerBlack, String location,String date) {
        this.players[0] = playerWhite;
        this.players[1] = playerBlack;
        this.location = location;
        this.date = date;
        gameID++;
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
    boolean addMove(String move) {
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
        char[] availableCharacters = {'1', '2', '3', '4', '5', '6', '7', '8',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'Q', 'K', 'N', 'B', 'R', 'x', '+', '=', '#'};
        if (move.length() < 2 || move.length() > 4) {
            for (int i = 0; i < move.length(); i++) {
                boolean found = false;
                for (char letter : availableCharacters) {
                    if (letter == move.charAt(i)) {
                        found = true;
                        break;
                    }
                }
                if (move.charAt(i) == '-') {
                    endGame(move);
                } else if (!found) {
                    return false;
                }
            }
        }
        return true;
    }

    //REQUIRES: A String representing a move
    //MODIFIES: this
    //EFFECTS: Ends the game and modifies the result
    boolean endGame(String move) {
        if (move.charAt(0) == '1') {
            result = 0;
            players[0].incrementWin();
            players[1].incrementLoss();
            return true;
        } else if (move.charAt(0) == '0') {
            result = 1;
            players[1].incrementWin();
            players[0].incrementLoss();
            return true;
        }
        return false;
    }
}

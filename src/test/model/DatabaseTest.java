package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private Database db1;
    Player player1;
    Player player2;
    @BeforeEach
    void beforeDatabase() {
        db1 = new Database();
        player1 = new Player("Magnus", "Grand Master", 2688, 10568, 7410);
        player2 = new Player("Mohsen");
    }

    @Test
    void testAddPlayer() {
        db1.addPlayer(player1);
        db1.addPlayer(player2);
    }

    @Test
    void testAddGame() {
        assertTrue(db1.addGame(new Game(player1, player2, "Coquitlam", "16/10/2022")));
        assertTrue(db1.addGame(new Game(player2, player1, "North Yankton", "22/10/2022")));
    }

    @Test
    void testSearchGame() {
        Game game1 = new Game(player2, player1, "North Yankton", "22/10/2022");
        db1.addGame(game1);
        int id1 = db1.games.get(0).getGameID();
        assertEquals(game1, db1.searchGame(id1));
        assertEquals(null, db1.searchGame(16561));
    }

    @Test
    void testSearchPlayer() {
        db1.addPlayer(player1);
        assertTrue(db1.searchPlayer("Magnus").getRating() == 2688);
        assertTrue(db1.searchPlayer("Abdul").getRating() == 0);
    }

    @Test
    void testGetGames() {
        Game game1 = new Game(player1, player2, "Coquitlam", "16/10/2022");
        Game game2 = new Game(player2, player1, "North Yankton", "22/10/2022");
        db1.addGame(game1);
        db1.addGame(game2);
        assertEquals(db1.getGames().get(1), game2);

    }

    @Test
    void testGetPlayers() {
        db1.addPlayer(player1);
        db1.addPlayer(player2);
        assertEquals(db1.getPlayers().get(1), player2);
    }
}

package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game1;
    private Game game2;
    private Player Bobby = new Player("Bobby Fischer", "Grand Master", 2785);
    private Player Boris = new Player("Boris Spassky", "Grand Master", 2660);

    @BeforeEach
    void beforeGame() {
        game1 = new Game(Boris, Bobby, "Iceland", "16/07/1972");
        game2 = new Game(Bobby, Boris, "Iceland", "23/07/1972");
    }

    @Test
    void testConstructor() {
        assertEquals(game1.getGameID(), 0);
        assertEquals(game2.getGameID(), 1);
        assertTrue(game1.getPlayers()[0] == Boris);
    }

    @Test
    void testMove() {
        assertTrue(game1.addMove("d4"));
        assertTrue(game1.addMove("Nf6"));
        assertTrue(game1.addMove("Bd3+"));
        assertFalse(game1.addMove("Yr3"));
        assertTrue(game1.addMove("1-0"));
        assertFalse(game1.addMove("d"));
    }

    @Test
    void testEndGame() {
        game2.addMove("f6");
        assertFalse(game2.endGame("001"));
        assertFalse(game2.endGame("z01"));
        assertFalse(game2.endGame("0-2"));
        assertTrue(game2.endGame("1-0"));
        assertTrue(Bobby.getWins() == 1);
        assertTrue(Boris.getLosses() == 1);
        assertTrue(game1.endGame("0-1"));
        assertTrue(Boris.getLosses() == 2);
        assertTrue(Bobby.getWins() == 2);

    }

    @Test
    void testPrint() {
        assertEquals(game1.printGame(),
        "Player with white pieces: " + "Boris Spassky" + " \n Player with the black pieces"
                + "Bobby Fischer" + "\n location:" + "Iceland" + "\n date: " + "16/07/1972"
                + "The winner of the game is: " + "Boris Spassky" + " ("
                + "Grand Master" + ")\n");
    }
}

package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player1;
    private Player player2;
    private Player player3;

    @BeforeEach
    void beforePlayer(){
        player1 = new Player("Magnus", "Grand Master", 2600);
        player2 = new Player("Hikaru", "Grand Master");
        player3 = new Player("Mohsen");
    }

    @Test
    void testConstructor() {
        assertEquals("Hikaru", player2.getName());
        assertEquals(player1.getTitle(), player2.getTitle());
        assertTrue(player1.getRating() > player2.getRating());
    }

    @Test
    void testRecord() {
        player1.incrementWin();
        player3.incrementLoss();
        assertTrue(player1.getWins() == 1);
        assertTrue(player3.getLosses() == 1);
    }

    @Test
    void testPrint() {
        assertEquals(player3.printPlayer(), "Player Name:" + "Mohsen"
                + " (" + "Amateur" + ") \n ELO rating: " + 0 + "\n Win/Loss Ratio: " + 1);
    }
}

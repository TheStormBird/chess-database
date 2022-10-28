package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WriterTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Database wr = new Database();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyDatabase() {
        try {
            Database db = new Database("Mohsen");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyDatabase.json");
            writer.open();
            writer.write(db);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyDatabase.json");
            db = reader.read();
            assertEquals("Mohsen", db.getName());
            assertEquals(0, db.getPlayers().size());
            assertEquals(0, db.getGames().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralDatabase() {
        try {
            Database db = new Database("Magnus");
            Player player1 = new Player("Magnus", "GM", 2980, 12000, 2000);
            Player player2 = new Player("Hikaru", "IM", 2680, 10000, 2000);
            db.addPlayer(player1);
            db.addPlayer(player2);
            db.addGame(new Game(player1, player2, "Iceland", "2021/02/18"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralDatabase.json");
            writer.open();
            writer.write(db);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralDatabase.json");
            db = reader.read();
            assertEquals("Magnus", db.getName());
            ArrayList<Player> players = db.getPlayers();
            assertEquals(2, players.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}

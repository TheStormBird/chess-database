package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Database wr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyDatabase() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyDatabase.json");
        try {
            Database db = reader.read();
            assertEquals("User", db.getName());
            assertEquals(0, db.getPlayers().size());
            assertEquals(0, db.getGames().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralDatabase() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralDatabase.json");
        try {
            Database db = reader.read();
            assertEquals("Magnus", db.getName());
            ArrayList<Player> players = db.getPlayers();
            ArrayList<Game> games = db.getGames();
            assertEquals(2, players.size());
            assertEquals(0, games.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}

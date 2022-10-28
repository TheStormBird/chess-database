package persistence;

import model.Game;
import model.Player;
import model.Database;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.json.*;

//Represents a reader that reads Database from the JSON data stored in file.
public class JsonReader {
    private String source;

    //EFFECTS: construct reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    //EFFECTS: reads Database from file and returns it;
    //throws IOException if an error occurs while reading data
    public Database read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseDatabase(jsonObject);
    }

    //EFFECTS: reads source file and returns as string
    private String readFile(String source) throws IOException {
        StringBuilder builder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> builder.append(s));
        }

        return builder.toString();
    }


    //EFFECTS: parses the database from JSON object and returns it
    private Database parseDatabase(JSONObject jsonObject) {
        String dbName = jsonObject.getString("name");
        Database db = new Database(dbName);
        addData(db, jsonObject);
        return db;
    }

    //MODIFIES: Database db
    //EFFECTS: parses data from the JSON object and adds them to Database
    private void addData(Database db, JSONObject jsonObject) {
        JSONArray gameArray = jsonObject.getJSONArray("games");
        JSONArray playerArray = jsonObject.getJSONArray("players");
        for (Object json: playerArray) {
            JSONObject nextPlayer = (JSONObject) json;
            addPlayer(db, nextPlayer);
        }
        for (Object json: gameArray) {
            JSONObject nextGame = (JSONObject) json;
            addGame(db, nextGame);
        }
    }

    //MODIFIES: db
    //EFFECTS: parses games from JSON object and adds it to Database
    private void addGame(Database db, JSONObject jsonObject) {
        String location = jsonObject.getString("location");
        String date = jsonObject.getString("date");
        Player[] players = new Player[2];
        players[0] = db.searchPlayer(jsonObject.getString("player0"));
        players[1] = db.searchPlayer(jsonObject.getString("player1"));
        JSONArray moves = jsonObject.getJSONArray("moves");
        Game game = new Game(players[0], players[1], location, date, convertJson(moves));
        db.addGame(game);
    }

    //MODIFIES: db
    //EFFECTS: parses players from JSON object and adds it to Database
    private void addPlayer(Database db, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String title = jsonObject.getString("title");
        int rating = jsonObject.getInt("rating");
        int wins = jsonObject.getInt("wins");
        int losses = jsonObject.getInt("losses");
        Player player = new Player(name, title, rating, wins, losses);
        db.addPlayer(player);
    }

    public ArrayList<String> convertJson(JSONArray jsonArray) {
        ArrayList<String> moves = new ArrayList<String>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                moves.add(jsonArray.getString(i));
            }
        }
        return moves;
    }


}

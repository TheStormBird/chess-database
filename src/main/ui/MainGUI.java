package ui;

import model.Database;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

//The main class for the GUI. Every graphic interface starts from here.
public class MainGUI extends JFrame implements ActionListener {
    private static final String JSON_STORE = "./data/database.json";
    Database database;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    JButton newPlayerBtn;
    JButton newGameBtn;
    JButton searchPlayerBtn;
    JButton searchGameBtn;
    JButton save;
    JButton load;

    //Starts the main page.
    public MainGUI(Database database) {
        super("Chess Database");
        this.database = database;
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());
        addButtons();
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("newPlayerBtn")) {
            new NewPlayerGUI(database);
        }
        if (e.getActionCommand().equals("newGameBtn")) {
            new NewGameGUI(database);
        }
        if (e.getActionCommand().equals("searchPlayerBtn")) {
            new SearchPlayerGUI(database);
        }
        if (e.getActionCommand().equals("searchGameBtn")) {
            new SearchGameGUI(database);
        }
        if (e.getActionCommand().equals("save")) {
            saveDatabase();
            database.getPlayers();
        }
        if (e.getActionCommand().equals("load")) {
            loadDatabase();
        }
    }

    void addMainButtons() {
        newPlayerBtn = new JButton("Add New Player");
        newGameBtn = new JButton("Add New Game");
        searchPlayerBtn = new JButton("Search for existing player");
        searchGameBtn = new JButton("Search for existing game");
        save = new JButton("save");
        load = new JButton("load");
        newPlayerBtn.setActionCommand("newPlayerBtn");
        newGameBtn.setActionCommand("newGameBtn");
        searchPlayerBtn.setActionCommand("searchPlayerBtn");
        searchGameBtn.setActionCommand("searchGameBtn");
        save.setActionCommand("save");
        load.setActionCommand("load");
        newGameBtn.addActionListener(this);
        newPlayerBtn.addActionListener(this);
        searchGameBtn.addActionListener(this);
        searchPlayerBtn.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);

    }

    void addButtons() {
        addMainButtons();
        add(newGameBtn);
        add(newPlayerBtn);
        add(searchPlayerBtn);
        add(searchGameBtn);
        add(save);
        add(load);
    }

    //EFFECTS:
    public void saveDatabase() {
        try {
            jsonWriter.open();
            jsonWriter.write(database);
            jsonWriter.close();
            System.out.println("Saved database to: " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    public void loadDatabase() {
        try {
            database = jsonReader.read();
            System.out.println("Loaded Database from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new MainGUI(new Database());
    }
}

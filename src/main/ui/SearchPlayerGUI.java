package ui;

import model.Database;
import model.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class SearchPlayerGUI extends JFrame {
    private Database database;
    private ArrayList<Player> players;
    private String playerNames = "<html>";

    public SearchPlayerGUI(Database database) {
        super("Search for an existing player");
        this.database = database;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));
        players = this.database.getPlayers();
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 40, 13));
        setLayout(new FlowLayout());
        addButtons();
        pack();
        setVisible(true);

    }

    private void addButtons() {
        JLabel names = new JLabel(getPlayerNames());
        add(names);
    }

    private String getPlayerNames() {
        for (Player player: players) {
            playerNames = playerNames + getPlayerDetails(player);
        }
        return playerNames;
    }

    private String getPlayerDetails(Player player) {
        String result = "Player's name is: " + player.getName() + " <br> and he is a(n) "
                + player.getTitle() + ".<br> His/Her ELO Rating: " + player.getRating()
                + " Total wins: " + player.getWins() + "Total losses: " + player.getLosses()
                + "<br>";
        return result;
    }

//    public static void main(String[] args) {
//        new SearchPlayerGUI(new Database());
//    }
}

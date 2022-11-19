package ui;

import model.Database;
import model.Game;
import model.Player;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument;
import javax.xml.crypto.Data;

public class NewGameGUI extends JFrame implements ActionListener {
    private Database database;
    JTextField location;
    JTextField date;
    JTextField player1;
    JTextField player2;
    JTextArea moves;
    JLabel dateLabel;
    JLabel locationLabel;
    JLabel player1Label;
    JLabel player2Label;
    JLabel movesLabel;
    JButton submit;

    public NewGameGUI(Database database) {
        super("Add a New Game");
        this.database = database;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());
        addButtons();
        pack();
        setVisible(true);

    }

    private void createButton() {
        location = new JTextField(12);
        locationLabel = new JLabel("Location: ");
        date = new JTextField(10);
        dateLabel = new JLabel("Date (MM/DD/YYYY):");
        player1 = new JTextField(12);
        player1Label = new JLabel("Player1 Name: ");
        player2 = new JTextField(12);
        player2Label = new JLabel("Player2 Name: ");
        moves = new JTextArea(5, 10);
        movesLabel = new JLabel("Moves (separated by ;)");
        submit = new JButton("submit");
    }

    private void addButtons() {
        createButton();
        add(locationLabel);
        add(location);
        add(dateLabel);
        add(date);
        add(player1Label);
        add(player1);
        add(player2Label);
        add(player2);
        add(movesLabel);
        add(moves);
        add(submit);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("submit")) {
            String gameLocation = location.getText();
            String gameDate = date.getText();
            Player playerOne = database.searchPlayer(player1.getText());
            Player playerTwo = database.searchPlayer(player2.getText());
            String movesText = moves.getText();
            ArrayList<String> gameMoves = new ArrayList<String>();
            String move = "";
            for (int i = 0;i < movesText.length(); i++) {
                if (movesText.charAt(i) == ';' || movesText.length() == i + 1) {
                    gameMoves.add(move);
                } else {
                    move = move + movesText.charAt(i);
                }
            }
            database.addGame(new Game(playerOne, playerTwo, gameLocation, gameDate, gameMoves));
        }
    }

    public static void main(String[] args) {
        new NewGameGUI(new Database());
    }
}

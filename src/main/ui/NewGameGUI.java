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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
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
        submit.setActionCommand("submit");
        submit.addActionListener(this);
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
            iterateMoves(move, movesText, gameMoves);
            Game game = new Game(playerOne, playerTwo, gameLocation, gameDate, gameMoves);
            database.addGame(game);
            int gameID = game.getGameID();
            JDialog window = new JDialog();
            JLabel label = new JLabel(String.valueOf(gameID));
            window.add(label);
            window.setBounds(500, 150, 300, 200);
            window.setVisible(true);
        }
    }

    public void iterateMoves(String move, String movesText, ArrayList<String> gameMoves) {
        for (int i = 0;i < movesText.length(); i++) {
            if (movesText.charAt(i) == ';') {
                gameMoves.add(move);
                move = "";
            } else {
                move = move + movesText.charAt(i);
            }
        }
    }

    public static void main(String[] args) {
        new NewGameGUI(new Database());
    }
}

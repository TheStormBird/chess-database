package ui;

import model.Database;
import model.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPlayerGUI extends JFrame implements ActionListener {
    private Database database;
    JTextField name;
    JLabel nameLabel;
    JTextField title;
    JLabel titleLabel;
    JTextField rating;
    JLabel ratingLabel;
    JTextField wins;
    JLabel winsLabel;
    JTextField losses;
    JLabel lossesLabel;
    JButton submit;

    public NewPlayerGUI(Database database) {
        super("Add a New Player");
        this.database = database;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());
        addButtons();
        submit.setActionCommand("submit");
        submit.addActionListener(this);
        pack();
        setVisible(true);
    }

    private void createButtons() {
        name = new JTextField(12);
        nameLabel = new JLabel("Name: ");
        title = new JTextField(12);
        titleLabel = new JLabel("Title: ");
        rating = new JTextField(4);
        ratingLabel = new JLabel("ELO Rating: ");
        wins = new JTextField(5);
        winsLabel = new JLabel("Wins: ");
        losses = new JTextField(5);
        lossesLabel = new JLabel("Losses: ");
        submit = new JButton("submit");
    }

    private void addButtons() {
        createButtons();
        add(nameLabel);
        add(name);
        add(titleLabel);
        add(title);
        add(ratingLabel);
        add(rating);
        add(winsLabel);
        add(wins);
        add(lossesLabel);
        add(losses);
        add(submit);
    }

    public static void main(String[] args) {
        new NewPlayerGUI(new Database());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("submit")) {
            String playerName = name.getText();
            String playerTitle = title.getText();
            int playerRating = Integer.parseInt(rating.getText());
            int playerWins = Integer.parseInt(wins.getText());
            int playerLosses = Integer.parseInt(wins.getText());
            Player player = new Player(playerName, playerTitle, playerRating, playerWins, playerLosses);
            database.addPlayer(player);
        }
    }
}

package ui;

import model.Database;
import model.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchGameGUI extends JFrame implements ActionListener {
    private Database database;
    JTextField gameID;

    public SearchGameGUI(Database database) {
        super("Search for an existing game");
        this.database = database;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());
        addButtons();
        pack();
        setVisible(true);

    }

    void addButtons() {
        gameID = new JTextField(5);
        JLabel label = new JLabel("Game ID: ");
        JButton submit = new JButton("submit");
        add(gameID);
        add(label);
        add(submit);
        submit.setActionCommand("submit");
        submit.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("submit")) {
            int id = Integer.parseInt(gameID.getText());
            JDialog window = new JDialog();
            Game game = database.searchGame(id);
            JLabel label = new JLabel(getGameDetails(game));
            window.add(label);
            window.setBounds(500, 150, 300, 200);
            window.setVisible(true);
        }
    }

    public String getGameDetails(Game game) {
        String result = "<html>" + "The game took place in: " + game.getLocation() + "<br>"
                + "The player on the white pieces: " + game.getPlayers()[0].getName() + "<br>"
                + "The player on the black pieces: " + game.getPlayers()[1].getName() + "<br>";
        if (game.getResult() == 0) {
            result = result + "The winner was: " + game.getPlayers()[0].getName() + "<br>";
        } else {
            result = result + "The winner was: " + game.getPlayers()[1].getName() + "<br>";
        }

        return result;
    }
}

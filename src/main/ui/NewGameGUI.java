package ui;

import model.Database;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NewGameGUI extends JFrame {
    private Database database;

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

    private void addButtons() {

    }
}

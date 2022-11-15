package ui;

import model.Database;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SearchGameGUI extends JFrame {
    private Database database;

    public SearchGameGUI(Database database) {
        super("Search for an existing game");
        this.database = database;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());
        addButtons();
        pack();
        setVisible(true);

    }

    void addButtons() {

    }
}

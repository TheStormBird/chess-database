package ui;

import model.Database;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

//The main class for the GUI. Every graphic interface starts from here.
public class MainGUI extends JFrame implements ActionListener {
    Database database;

    //Starts the main page.
    public MainGUI(Database database) {
        super("Chess Database");
        this.database = database;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());
        addMainButtons();
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
    }

    void addMainButtons() {
        JButton newPlayerBtn = new JButton("Add New Player");
        JButton newGameBtn = new JButton("Add New Game");
        JButton searchPlayerBtn = new JButton("Search for existing player");
        JButton searchGameBtn = new JButton("Search for existing game");
        newPlayerBtn.setActionCommand("newPlayerBtn");
        newGameBtn.setActionCommand("newGameBtn");
        searchPlayerBtn.setActionCommand("searchPlayerBtn");
        searchGameBtn.setActionCommand("searchGameBtn");
        newGameBtn.addActionListener(this);
        newPlayerBtn.addActionListener(this);
        searchGameBtn.addActionListener(this);
        searchGameBtn.addActionListener(this);
        add(newGameBtn);
        add(newPlayerBtn);
        add(searchPlayerBtn);
        add(searchGameBtn);
    }

    public static void main(String[] args) {
        new MainGUI(new Database());
    }
}

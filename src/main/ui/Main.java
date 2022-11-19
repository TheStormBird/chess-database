package ui;

import model.Database;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new MainGUI(new Database());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

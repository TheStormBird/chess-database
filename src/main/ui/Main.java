package ui;

import model.Database;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new DatabaseApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file: file not found");
        }
    }


}

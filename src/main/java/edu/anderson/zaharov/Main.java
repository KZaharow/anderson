package edu.anderson.zaharov;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws NullPointerException {

        try {
            Files.readAllLines(Paths.get("Test.txt"));
        } catch (NoSuchFileException | IOException e) {
            e.printStackTrace();
        }
    }
}

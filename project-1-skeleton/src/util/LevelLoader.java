package util;

import entity.*;
import model.Level;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LevelLoader {

    private List<Ghost> ghosts;
    private List<Dot> dots;
    private List<Wall> walls;
    private Pac pac;

    public Level loadLevel(String filename) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        Scanner scanner = new Scanner(fileInputStream);

        ghosts = new ArrayList<>();
        dots = new ArrayList<>();
        walls = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Bad format: " + line);
            }
            String key = parts[0];
            int x, y;
            try {
                x = Integer.parseInt(parts[1]);
                y = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Bad format: " + line);
            }
            loadEntity(key, x, y);
        }
        fileInputStream.close();
        scanner.close();

        if (pac == null) {
            throw new IllegalStateException("No pac");
        }
        return new Level(ghosts, dots, walls, pac);
    }

    private void loadEntity(String key, int x, int y) {
        Loc loc = new Loc(x, y);
        switch (key) {
            case "Player":
                pac = new Pac(loc);
                break;
            case "Ghost":
                ghosts.add(new Ghost(loc));
                break;
            case "Wall":
                walls.add(new Wall(loc));
                break;
            case "Dot":
                dots.add(new Dot(loc));
                break;
            default:
                throw new IllegalArgumentException("Unidentifiable entity type: " + key);
        }
    }
}

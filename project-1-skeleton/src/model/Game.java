package model;

import bagel.Keys;
import util.Dir;
import util.Drawings;
import util.LevelLoader;
import util.Loc;

import java.io.IOException;

public class Game {
    public enum GameResult {
        None, Win, GameOver
    }
    private Level level;
    private final LevelLoader levelLoader = new LevelLoader();

    private GameResult gameResult;

    public static final int TargetScore = 1210;

    public void loadLevel(int levelNo) {
        String filename = "res/level" + levelNo + ".csv";
        try {
            level = levelLoader.loadLevel(filename);
        } catch (IOException e) {
            throw new RuntimeException("File " + filename + " cannot be found");
        }
    }

    public void draw() {
        level.draw();
        drawLives();
        drawScore();
    }

    private void drawScore() {
        Drawings.getInstance().drawText("SCORE " + level.getScoreCollected(), new Loc(25, 25), Drawings.FontSize.Score);
    }

    private void drawLives() {
        for (int i = 0; i < liveRemains; i++) {
            Drawings.getInstance().drawImage(Drawings.Heart, new Loc(900 + 30 * i, 10));
        }
    }

    public void update() {
        level.update();
        if (level.isDead()) {
            if (liveRemains == 0) {
                gameResult = GameResult.GameOver;
            } else {
                --liveRemains;
                level.reset();
            }
        }
        if (level.getScoreCollected() == TargetScore) {
            gameResult = GameResult.Win;
        }
    }

    public void onKeyStroke(Keys key) {
        switch (key) {
            case A: level.movePac(Dir.Left); break;
            case D: level.movePac(Dir.Right); break;
            case W: level.movePac(Dir.Up); break;
            case S: level.movePac(Dir.Down); break;
        }
    }

    public GameResult gameResult() {
        return gameResult;
    }

    private int liveRemains = 3;
}

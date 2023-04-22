package util;

import bagel.DrawOptions;
import bagel.Font;
import bagel.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Drawings {
    private Drawings() {
        loadImages();
        loadFont();
    }

    public enum FontSize {
        Message(64),
        SmallMessage(24),
        Score(20);
        public final int size;

        FontSize(int size) {
            this.size = size;
        }
    }

    private static Drawings instance;
    public static Drawings getInstance() {
        return instance == null ? (instance = new Drawings()) : instance;
    }

    private void loadImages() {
        Stream.of(GhostRed, Pac, PacOpen, Wall, Heart, Background, Dot).forEach(key -> imageMap.put(key, new Image(key)));
    }

    private void loadFont() {
        String filename = "res/FSO8BITR.TTF";
        fontMap.put(FontSize.Message, new Font(filename, FontSize.Message.size));
        fontMap.put(FontSize.Score, new Font(filename, FontSize.Score.size));
        fontMap.put(FontSize.SmallMessage, new Font(filename, FontSize.SmallMessage.size));
    }

    public void drawImage(String key, Loc loc) {
        Image image = imageMap.get(key);
        if (image == null) {
            return;
        }
        image.drawFromTopLeft(loc.x, loc.y);
    }

    public void drawImage(String key, Loc loc, Dir dir) {
        Image image = imageMap.get(key);
        if (image == null) {
            return;
        }
        DrawOptions options = new DrawOptions();
        options.setRotation(dir.rotation);
        image.drawFromTopLeft(loc.x, loc.y, options);
    }

    public void drawText(String text, Loc loc, FontSize fontSize) {
        Font font = fontMap.get(fontSize);
        font.drawString(text, loc.x, loc.y);
    }

    private final Map<FontSize, Font> fontMap = new HashMap<>();
    private final Map<String, Image> imageMap = new HashMap<>();
    public static final String GhostRed = "res/ghostRed.png";
    public static final String Pac = "res/pac.png";
    public static final String PacOpen = "res/pacOpen.png";
    public static final String Dot = "res/dot.png";
    public static final String Wall = "res/wall.png";
    public static final String Heart = "res/heart.png";
    public static final String Background = "res/background0.png";
}

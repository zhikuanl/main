package entity;

import util.Drawings;
import util.Loc;

public class Wall extends Entity {
    public static final int Height = 50, Width = 50;
    @Override
    public void draw() {
        Drawings.getInstance().drawImage(Drawings.Wall, loc);
    }

    public Wall(Loc loc) {
        super(loc, Height, Width);
    }
}

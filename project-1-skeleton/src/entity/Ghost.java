package entity;

import util.Drawings;
import util.Loc;

public class Ghost extends Entity {
    public static final int Height = 25, Width = 25;
    @Override
    public void draw() {
        Drawings.getInstance().drawImage(Drawings.GhostRed, loc);
    }

    public Ghost(Loc loc) {
        super(loc, Height, Width);
    }
}

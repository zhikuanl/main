package entity;

import util.Drawings;
import util.Loc;

public class Dot extends Entity{
    public static final int Height = 26, Width = 26;
    @Override
    public void draw() {
        Drawings.getInstance().drawImage(Drawings.Dot, loc);
    }

    public Dot(Loc loc) {
        super(loc, Height, Width);
    }
}

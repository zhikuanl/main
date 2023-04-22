package entity;

import util.Loc;

public abstract class Entity implements HasLoc {
    protected Loc loc;
    protected final int height, width;

    public abstract void draw();

    public Entity(Loc loc, int height, int width) {
        this.loc = loc;
        this.height = height;
        this.width = width;
    }

    public void update() {}

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public Loc getLoc() {
        return loc;
    }
}

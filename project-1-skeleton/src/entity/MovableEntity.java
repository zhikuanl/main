package entity;

import util.Dir;
import util.Loc;

public abstract class MovableEntity extends Entity {
    protected Dir dir = Dir.Right;
    protected int speed;

    public MovableEntity(Loc loc, int height, int width, Dir dir, int speed) {
        super(loc, height, width);
        this.dir = dir;
        this.speed = speed;
    }

    public void translate(Dir dir) {
        loc = new Loc(loc.x + dir.x * speed, loc.y + dir.y * speed);
        this.dir = dir;
    }

    public void rotate(Dir dir) {
        this.dir = dir;
    }

    public Dir getDir() {
        return dir;
    }
}

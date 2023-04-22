package model;

import bagel.util.Rectangle;
import entity.*;
import util.Dir;
import util.Drawings;
import util.Loc;

import java.util.List;
import java.util.stream.Collectors;

public class Level {
    private final List<Ghost> ghosts;
    private List<Dot> dots;
    private final List<Wall> walls;
    private final Pac pac;
    private final int initiaDotCount;

    private boolean isDead = false;

    boolean doesCollide(Entity entity, Loc loc) {
        return new Rectangle(entity.getLoc().x, entity.getLoc().y, entity.getWidth(), entity.getHeight()).intersects(
                new Rectangle(loc.x, loc.y, pac.getWidth(), pac.getHeight())
        );
    }

    public Level(List<Ghost> ghosts, List<Dot> dots, List<Wall> walls, Pac pac) {
        this.ghosts = ghosts;
        this.dots = dots;
        this.walls = walls;
        this.pac = pac;
        initiaDotCount = dots.size();
    }

    public void movePac(Dir dir) {
        int nx = pac.getLoc().x + dir.x * Pac.MoveSpeed;
        int ny = pac.getLoc().y + dir.y * Pac.MoveSpeed;
        Loc nextLoc = new Loc(nx, ny);
        for (Entity entity : walls) {
            if (doesCollide(entity, nextLoc)) {
                return;
            }
        }
        pac.translate(dir);
    }

    public void draw() {
        Drawings.getInstance().drawImage(Drawings.Background, Loc.origin());
        for (Entity entity : walls) {
            entity.draw();
        }
        for (Entity entity : dots) {
            entity.draw();
        }
        for (Entity entity : ghosts) {
            entity.draw();
        }
        pac.draw();
    }

    public void update() {
        if (isDead) {
            return;
        }
        for (Entity entity : ghosts) {
            if (doesCollide(entity, pac.getLoc())) {
                isDead = true;
                return;
            }
        }
        for (Entity entity : dots) {
            if (doesCollide(entity, pac.getLoc())) {
                eatDot(entity);
                break;
            }
        }
        pac.update();
    }

    private void eatDot(Entity dot) {
        dots = dots.stream().filter(d -> d != dot).collect(Collectors.toList());
    }

    public boolean isDead() {
        return isDead;
    }

    public void reset() {
        isDead = false;
        pac.resetLoc();
    }

    public int getScoreCollected() {
        return (initiaDotCount - dots.size()) * 10;
    }
}

package util;

public class Loc {
    public final int x, y;

    public Loc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Loc origin() {
        return new Loc(0, 0);
    }
}

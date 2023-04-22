package util;

public enum Dir {
    Left(-1, 0, Math.PI),
    Right(1, 0, 0),
    Up(0, -1, Math.PI * 1.5),
    Down(0, 1, Math.PI * 0.5);

    public final int x, y;
    public final double rotation;

    Dir(int x, int y, double rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }
}

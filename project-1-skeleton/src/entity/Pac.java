package entity;

import util.Dir;
import util.Drawings;
import util.Loc;

public class Pac extends MovableEntity {
    enum OpenState {Open, Close};

    public static final int FramesToSwitchOpenness = 15;
    public static final int MoveSpeed = 3;

    public static final int Height = 25, Width = 25;

    private OpenState openState = OpenState.Close;
    private int currentFrames = FramesToSwitchOpenness;

    private final Loc initialLoc;

    //private int livesRemaining = 3;


    @Override
    public void draw() {
        Drawings.getInstance().drawImage(openState == OpenState.Open ? Drawings.PacOpen : Drawings.Pac, loc, dir);
    }

    @Override
    public void update() {
        --currentFrames;
        if (currentFrames == 0) {
            currentFrames = FramesToSwitchOpenness;
            openState = openState == OpenState.Open ? OpenState.Close : OpenState.Open;
        }
    }

/*    public void loseLive() {
        if (livesRemaining <= 0) {
            throw new IllegalStateException("Already dead");
        }
        --livesRemaining;
    }*/

    public Pac(Loc loc) {
        super(loc, Height, Width, Dir.Right, MoveSpeed);
        initialLoc = loc;
    }

    public void resetLoc() {
        loc = initialLoc;
    }
}

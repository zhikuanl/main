package state;

import bagel.Keys;

public abstract class State {
    public static final String StateBeginning = "StateBeginning";
    public static final String StateGaming = "StateGaming";
    public static final String StateGameOver = "StateGameOver";
    public static final String StateWin = "StateGameWin";
    protected final StateManager stateManager;

    public State(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public abstract void draw();

    public void update() {}

    public void onKeyStroke(Keys key) {}
}

package state;

import bagel.Keys;
import model.Game;

public class GamingState extends State {
    private final Game game;

    public GamingState(StateManager stateManager, Game game) {
        super(stateManager);
        this.game = game;
    }

    @Override
    public void draw() {
        game.draw();
    }

    @Override
    public void update() {
        game.update();
        if (game.gameResult() == Game.GameResult.GameOver) {
            stateManager.transfer(State.StateGameOver);
        } else if (game.gameResult() == Game.GameResult.Win) {
            stateManager.transfer(State.StateWin);
        }
    }

    @Override
    public void onKeyStroke(Keys key) {
        game.onKeyStroke(key);
    }
}

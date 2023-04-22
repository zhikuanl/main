import bagel.*;
import model.Game;
import state.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Skeleton Code for SWEN20003 Project 1, Semester 1, 2023
 *
 * Please enter your name below
 * @author
 */
public class ShadowPac extends AbstractGame implements StateManager {
    private final static int WINDOW_WIDTH = 1024;
    private final static int WINDOW_HEIGHT = 768;
    private final static String GAME_TITLE = "SHADOW PAC";

    private Game initGame() {
        Game game = new Game();
        game.loadLevel(0);
        return game;
    }
    public ShadowPac(){
        super(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_TITLE);
        stateMap.put(State.StateBeginning, new GameBeginState(this));
        stateMap.put(State.StateGaming, new GamingState(this, initGame()));
        stateMap.put(State.StateGameOver, new GameOverState(this));
        stateMap.put(State.StateWin, new GameWinState(this));
        transfer(State.StateBeginning);
    }


    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
        ShadowPac game = new ShadowPac();
        game.run();
    }

    /**
     * Performs a state update.
     * Allows the game to exit when the escape key is pressed.
     */
    @Override
    protected void update(Input input) {

        if (input.wasPressed(Keys.ESCAPE)){
            Window.close();
        }
        currentState.draw();
        for (Keys key : processKeys) {
            if (input.isDown(key)) {
                currentState.onKeyStroke(key);
            }
        }
        currentState.update();
    }

    private static final List<Keys> processKeys = List.of(Keys.A, Keys.S, Keys.D, Keys.W, Keys.SPACE);


    private final Map<String, State> stateMap = new HashMap<>();
    private State currentState;
    @Override
    public void transfer(String key) {
        currentState = stateMap.get(key);
    }
}

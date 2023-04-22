package state;

import util.Drawings;
import util.Loc;

public class GameOverState extends State {
    @Override
    public void draw() {
        Drawings.getInstance().drawImage(Drawings.Background, Loc.origin());
        Drawings.getInstance().drawText("GAME OVER!", new Loc(260, 250), Drawings.FontSize.Message);
    }

    public GameOverState(StateManager stateManager) {
        super(stateManager);
    }
}

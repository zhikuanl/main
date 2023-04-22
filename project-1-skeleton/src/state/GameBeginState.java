package state;

import bagel.Keys;
import util.Drawings;
import util.Loc;

public class GameBeginState extends State {

    public GameBeginState(StateManager stateManager) {
        super(stateManager);
    }

    @Override
    public void draw() {
        Drawings.getInstance().drawImage(Drawings.Background, Loc.origin());
        Drawings.getInstance().drawText("SHADOW PAC", new Loc(260, 250), Drawings.FontSize.Message);
        Drawings.getInstance().drawText("PRESS SPACE TO START", new Loc(350, 440), Drawings.FontSize.SmallMessage);
        Drawings.getInstance().drawText("USE ARROW KEYS TO MOVE", new Loc(350, 480), Drawings.FontSize.SmallMessage);
    }


    @Override
    public void onKeyStroke(Keys key) {
        if (key == Keys.SPACE) {
            stateManager.transfer(State.StateGaming);
        }
    }
}

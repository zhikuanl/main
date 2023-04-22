package state;

import util.Drawings;
import util.Loc;

public class GameWinState extends State {
    public GameWinState(StateManager stateManager) {
        super(stateManager);
    }

    @Override
    public void draw() {
        Drawings.getInstance().drawImage(Drawings.Background, Loc.origin());
        Drawings.getInstance().drawText("WELL DONE!", new Loc(260, 250), Drawings.FontSize.Message);
    }
}

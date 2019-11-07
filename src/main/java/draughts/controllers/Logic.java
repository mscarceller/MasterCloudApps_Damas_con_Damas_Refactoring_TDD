package draughts.controllers;

import java.util.HashMap;
import java.util.Map;

import draughts.models.Game;
import draughts.models.State;
import draughts.models.StateValue;

public class Logic {

	private State state;
	private Game game;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;
	private Map<StateValue, Controller> controllers;

	public Logic() {
		this.state = new State();
		this.game = new Game();
        this.controllers = new HashMap<StateValue, Controller>();
		this.startController = new StartController(game,state);
		this.playController = new PlayController(game,state);
		this.resumeController = new ResumeController(game,state);
		this.controllers.put(StateValue.INITIAL, this.startController);
		this.controllers.put(StateValue.IN_GAME, this.playController);
		this.controllers.put(StateValue.FINAL, this.resumeController);
		this.controllers.put(StateValue.EXIT, null);
	}

	public Controller getController() {
		return this.controllers.get(this.state.getValueState());
    }

}

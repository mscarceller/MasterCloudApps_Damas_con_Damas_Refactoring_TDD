package draughts.controllers;

import java.util.HashMap;
import java.util.Map;

import draughts.models.Game;
import draughts.models.State;
import draughts.models.StateValue;

public class Logic {

	private State state;
	private Game game;
	private Map<StateValue, Controller> controllers;

	public Logic() {
		this.state = new State();
		this.game = new Game();
        this.controllers = new HashMap<StateValue, Controller>();
		this.controllers.put(StateValue.INITIAL, new StartController(game,state));
		this.controllers.put(StateValue.IN_GAME, new PlayController(game,state));
		this.controllers.put(StateValue.FINAL, new ResumeController(game,state));
		this.controllers.put(StateValue.EXIT, null);
	}

	public Controller getController() {
		return this.controllers.get(this.state.getValueState());
    }

}

package draughts.controllers;

import draughts.models.Game;
import draughts.models.State;

public abstract class Controller {

	protected Game game;
	protected State state;
	
    protected Controller(Game game, State state) {
		this.game = game;
		this.state = state;
    }

	abstract public void accept(ControllersVisitor controllersVisitor);
    
}

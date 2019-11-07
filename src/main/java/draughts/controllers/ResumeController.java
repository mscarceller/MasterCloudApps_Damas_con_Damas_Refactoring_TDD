package draughts.controllers;

import draughts.models.Game;
import draughts.models.State;

public class ResumeController extends Controller {

	public ResumeController(Game game, State state) {
		super(game, state);
	}
    
    @Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

	public void next() {
        this.state.next();
	}

	public void reset() {
        this.state.reset();
	}

}

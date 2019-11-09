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

	public void isNewGame(boolean newGame) {
		if (newGame) {
			this.newGame();
		} else {
			this.exitGame();
		}
	}

	public void newGame(){
		this.game.initGame();
		this.state.reset();
	}

	public void exitGame(){
		this.state.next();
	}
}

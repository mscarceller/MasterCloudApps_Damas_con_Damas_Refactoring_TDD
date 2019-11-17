package draughts.controllers;

import draughts.models.Coordinate;
import draughts.models.Game;
import draughts.models.Error;

public class MoveController {

	private Game game;

	public MoveController(Game game) {
		this.game = game;
	}

	public void move(Coordinate origin, Coordinate target) {
		assert this.isCorrect(origin, target) == null;
		this.game.move(origin, target);
	}

	public Error isCorrect(Coordinate origin, Coordinate target){
		assert origin != null;
		assert target != null;
		return this.game.isCorrect(origin, target);
	}	

}
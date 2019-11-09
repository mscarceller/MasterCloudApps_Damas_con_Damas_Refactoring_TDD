package draughts.controllers;

import draughts.models.Coordinate;
import draughts.models.Game;
import draughts.models.Error;

public class MoveController {

	private Game game;

	public MoveController(Game game) {
		this.game = game;
	}

	public Error move(Coordinate origin, Coordinate target) {
		return this.game.move(origin, target);
	}

}
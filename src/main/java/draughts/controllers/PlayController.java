package draughts.controllers;

import draughts.models.Color;
import draughts.models.Coordinate;
import draughts.models.Piece;
import draughts.models.State;
import draughts.models.Error;
import draughts.models.Game;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
		super(game, state);
	}

	public Error move(Coordinate origin, Coordinate target){
		return this.game.move(origin, target);
    }

	public Piece getPiece(Coordinate coordinate) {
		return this.game.getPiece(coordinate);
	}

	public Color getColor() {
		return this.game.getColor();
	}

	public void gameOver(){
		this.state.next();
	}
	
	public boolean isBlocked() {
		return this.game.isBlocked();
	}	

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}